<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 自习室列表
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-input type="number" v-model="Rsearcher.rid" placeholder="movieID"
                          class="handle-input mr10"></el-input>
                <!--<el-input type="number" v-model="Csearcher.cinemaId" placeholder="cinemaID" class="handle-input mr10">
            </el-input>-->
                <el-button type="primary" icon="el-icon-search" @click="roomSearch">搜索自习室</el-button>
                <!--<el-button type="primary" icon="el-icon-plus" @click="handleAdd">新增自习室</el-button>-->
            </div>
            <el-table :data="movie" border class="table" ref="multipleTable" header-cell-class-name="table-header"
                      @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="55" align="center"></el-table-column>
                <el-table-column prop="rid" label="自习室编号" align="center"></el-table-column>
                <el-table-column prop="seat_amount" label="座位数" align="center"></el-table-column>
                <el-table-column prop="open_time" label="开放起始时间" align="center"></el-table-column>
                <el-table-column prop="close_time" label="开放结束时间" align="center"></el-table-column>
                <el-table-column prop="max_booking_time" label="最大预约小时数" align="center"></el-table-column>
                <!--<el-table-column prop="overnight" label="是否通宵开放" align="center"></el-table-column> -->
                <el-table-column prop="overnight" label="是否通宵开放" align="center">
                    <template slot-scope="scope">
                        <h1 v-if="scope.row.overnight == 1">
                            <div style="font-size:12px">
                                是
                            </div>
                        </h1>
                        <h1 v-else style="font-size:12px">
                            <div>
                                否
                            </div>
                        </h1>
                    </template>
                </el-table-column>
                <el-table-column prop="open" label="当前状态" align="center">
                    <template slot-scope="scope">
                        <h1 v-if="scope.row.open == 1">
                            <div style="font-size:12px">
                                开放
                            </div>
                        </h1>
                        <h1 v-else style="font-size:12px">
                            <div>
                                未开放
                            </div>
                        </h1>
                    </template>
                </el-table-column>

                <el-table-column label="操作" width="200" align="center">
                    <template slot-scope="scope">
                        <el-button type="text" icon="el-icon-edit"
                                   @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                        <el-button type="text" icon="el-icon-search"
                                   @click="handleCheck(scope.$index, scope.row, scope.row.rid)">查看座位</el-button>
                        <!--<el-button type="text" icon="el-icon-delete" class="red"
                                   @click="handleDelete(scope.$index, scope.row)">删除</el-button>-->
                    </template>
                </el-table-column>
            </el-table>

            <div class="pagination">
                <el-pagination background layout="total, prev, pager, next" :current-page="query.pageIndex"
                               :page-size="query.pageSize" :total="pageTotal" @current-change="handlePageChange"></el-pagination>
            </div>
        </div>
        <el-dialog title="查看自习室座位" :visible.sync="seatVisible" width="60%">
            <el-input type="number" v-model="Ssearcher.id" placeholder="输入座位id"
                      class="handle-input mr10"></el-input>
            <el-button @click="seatSearch()">搜索座位</el-button>
            <div class="container">
                <el-table :data="showsth" border class="table" ref="multipleTable"
                          header-cell-class-name="table-header">
                    <el-table-column prop="zid" label="座位编号" width="100" align="center"></el-table-column>
                    <!--<el-table-column prop="cinema_name" label="是否靠近插座" align="center"></el-table-column>-->
                    <el-table-column prop="socket" label="是否靠近插座" width="120" align="center">
                        <template slot-scope="scope">
                            <h1 v-if="scope.row.socket == 1">
                                <div style="font-size:12px">
                                    是
                                </div>
                            </h1>
                            <h1 v-else style="font-size:12px">
                                <div>
                                    否
                                </div>
                            </h1>
                        </template>
                    </el-table-column>


                    <el-table-column prop="today_book" label="今日预约" align="center" width="315">
                        <template slot-scope="scope">
                            <el-row>
                                <el-col span="4" v-for="(book, index) in scope.row.today_book">
                                    <el-button v-if="book == '0'" type="primary" size="mini" circle>{{index}}:00</el-button>
                                    <el-button v-else type="danger" size="mini" circle>{{index}}:00</el-button>
                                </el-col>
                            </el-row>
                        </template>
                    </el-table-column>

                    <el-table-column prop="next_book" label="明日预约" align="center" width="315">
                        <template slot-scope="scope">
                            <el-row>
                                <el-col span="4" v-for="(book, index) in scope.row.next_book">
                                    <el-button v-if="book == '0'" type="primary" size="mini" circle>{{index}}:00</el-button>
                                    <el-button v-else type="danger" size="mini" circle>{{index}}:00</el-button>
                                </el-col>
                            </el-row>
                        </template>
                    </el-table-column>

                    <!--<div v-for="(book, index) in scope.row.today_book">
        <el-button v-if="book == '0'" type="primary" size="mini" circle>{{index}}:00</el-button>
        <el-button v-else type="danger" size="mini" circle>{{index}}:00</el-button>
    </div>-->
                    <!--<el-table-column prop="next_book" label="明日预约" align="center" width="150"></el-table-column>-->
                </el-table>
                <table cellpadding="0" cellspacing="0">
                    <tr v-for='(seatline, i) in seatData' :key="i">
                        <td v-for='(index, j) in seatline' :key="j">
                            <h1 v-if="index == true">
                                <div>
                                    <el-button type="primary" @click="handleChosen(i + 1, j + 1)">Y</el-button>
                                </div>
                            </h1>
                            <h1 v-else>
                                <el-button type="warning" plain disabled>N</el-button>
                            </h1>
                        </td>
                    </tr>
                </table>
            </div>
            <span slot="footer" class="dialog-footer">
                <!--<el-button @click="seatVisible = false">取 消</el-button>-->
                <el-button type="primary" @click="seatVisible = false">确 定</el-button>
            </span>
        </el-dialog>

        <!--重复的一段-->
        <el-dialog :visible.sync="seatSearchVisible" width="50%">         
            <div class="container">
                <el-table :data="seatIn" border class="table" ref="multipleTable"
                          header-cell-class-name="table-header">
                    <el-table-column prop="zid" label="座位编号" width="100" align="center"></el-table-column>
                    <!--<el-table-column prop="cinema_name" label="是否靠近插座" align="center"></el-table-column>-->
                    <el-table-column prop="socket" label="是否靠近插座" width="120" align="center">
                        <template slot-scope="scope">
                            <h1 v-if="scope.row.socket == 1">
                                <div style="font-size:12px">
                                    是
                                </div>
                            </h1>
                            <h1 v-else style="font-size:12px">
                                <div>
                                    否
                                </div>
                            </h1>
                        </template>
                    </el-table-column>


                    <!--<el-table-column prop="today_book" label="今日预约" align="center" width="150"></el-table-column>
    <el-table-column prop="next_book" label="明日预约" align="center" width="150"></el-table-column>-->
                    <el-table-column prop="today_book" label="今日预约" align="center" width="315">
                        <template slot-scope="scope">
                            <el-row>
                                <el-col span="4" v-for="(book, index) in scope.row.today_book">
                                    <el-button v-if="book == '0'" type="primary" size="mini" circle>{{index}}:00</el-button>
                                    <el-button v-else type="danger" size="mini" circle>{{index}}:00</el-button>
                                </el-col>
                            </el-row>
                        </template>
                    </el-table-column>

                    <el-table-column prop="next_book" label="明日预约" align="center" width="315">
                        <template slot-scope="scope">
                            <el-row>
                                <el-col span="4" v-for="(book, index) in scope.row.next_book">
                                    <el-button v-if="book == '0'" type="primary" size="mini" circle>{{index}}:00</el-button>
                                    <el-button v-else type="danger" size="mini" circle>{{index}}:00</el-button>
                                </el-col>
                            </el-row>
                        </template>
                    </el-table-column>
                </el-table>
                <table cellpadding="0" cellspacing="0">
                    <tr v-for='(seatline, i) in seatData' :key="i">
                        <td v-for='(index, j) in seatline' :key="j">
                            <h1 v-if="index == true">
                                <div>
                                    <el-button type="primary" @click="handleChosen(i + 1, j + 1)">Y</el-button>
                                </div>
                            </h1>
                            <h1 v-else>
                                <el-button type="warning" plain disabled>N</el-button>
                            </h1>
                        </td>
                    </tr>
                </table>
            </div>
            <span slot="footer" class="dialog-footer">
                <!--<el-button @click="seatSearchVisible = false">确定</el-button>-->
                <el-button type="primary" @click="seatSearchVisible = false">确 定</el-button>
            </span>
        </el-dialog>


        <el-dialog title="自习室" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="query" label-width="120px">
                <el-form-item label="自习室编号">
                    <el-input v-model="query.rid"></el-input>
                </el-form-item>
                <el-form-item label="座位数">
                    <el-input v-model="query.seat_amount"></el-input>
                </el-form-item>
                <el-form-item label="开放起始时间">
                    <el-input v-model="query.open_time"></el-input>
                </el-form-item>
                <el-form-item label="开放结束时间">
                    <el-input v-model="query.close_time"></el-input>
                </el-form-item>
                <el-form-item label="最大预约小时数">
                    <el-input v-model="query.max_booking_time"></el-input>
                </el-form-item>
                <el-form-item label="是否通宵开放">
                    <el-input v-model="query.overnight" placeholder="输入0为否,输入1为是"></el-input>
                </el-form-item>
                <el-form-item label="当前状态">
                    <el-input v-model="query.open" placeholder="输入0为不开放,输入1为开放"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false;">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog>
    </div>
</template>

<script>
//import { updateFilm, deleteCinema, getAllFilm, insertFilm, getCinema } from '../../api/index';
import { adminUpdateStudyroom, getAllStudyroom, getAllSeat, getSeatInfo } from '../../api/index';
export default {
    name: 'basetable',
    data() {
        return {
            Rsearcher: {
                rid: 1
            },
            Csearcher: {
                cinemaId: 1
            },
            scheduleInfo: [{
                hall_id: 1,
                schedule_startTime: "2022-12-21 17:30",
                schedule_remain: 144,
                film_id: 25,
                schedule_price: 38.0,
                schedule_state: 1,
                schedule_id: 25,
                cinema_id: 1
            }],
            showsth: [{
                id: 2,
                zid: 1,
                rid: 1,
                today_book: "000000000011110011111111",
                next_book: "000000000011111000000000",
                socket: true,
                //film_name: "film_name",
                //cinema_name: "cinema_name",
                //schedule_price: 0
            }],
            seatIn: [{
                id: 1,
                zid: 100,
                rid: 1,
                today_book: "000000000011110000000000",
                next_book: "100000000011111000000000",
                socket: true,
            }],
            Ssearcher: {
                id: 1
            },          
            movie: [{
                rid: 1,
                seat_amount: 100,
                open_time: 8,
                close_time: 22,
                max_booking_time: 4,
                overnight: 1,
                open: 1,
                rname: ''
            }],
            query: {
                rid: 1000,
                seat_amount: 0,
                open_time: 0,
                close_time: 0,
                film_comment_count: 0,
                max_booking_time: 1,
                overnight: 1,
                open: 0,
                rname: ''
            },
            inserter: {
                rid: 1,
                film_box_office: 1.0,
                seat_amount: 0,
                open_time: 0,
                close_time: 0,
                film_comment_count: 0,
                max_booking_time: 1,
                overnight: 1,
                open: 0,
                film_release_date: '',
                film_picture: 'none.png',
                film_state: 1,
                film_detail: '',
                film_fg_name: ''
            },
            tableData: [],
            seatData: [],
            multipleSelection: [],
            delList: [],
            editVisible: false,
            resultVisible: false,
            seatVisible: false,
            seatSearchVisible: false,
            pageTotal: 1,
            form: {},
            idx: -1,
            id: -1,
            editOrNot: 1,
            token: "user"
        };
    },
    created() {
        this.get_allfilm();
        this.initSeats();
        this.gettoken();
    },
    methods: {
        clearer() {
            this.query = this.inserter;
        },
        gettoken() {
            this.token = localStorage.getItem('ms_username');
        },
        initSeats() {
            for (var i = 0; i < 12; i++) {
                this.seatData[i] = new Array();
                for (var j = 0; j < 12; j++) {
                    this.seatData[i][j] = true;
                }
            }
        },
        get_allfilm() {
            getAllFilm().then(res => {
                this.movie = res.data;
            });
        },
        handleChosen(row, col) {
            this.orderInfo.orderRow = row;
            this.orderInfo.orderCol = col;
        },
        roomSearch() {
            getAllStudyroom().then(res => {
                console.log(res);
                this.query = res.records[0];
                this.movie = res.records;
                for(var i = 0; i < this.movie.length; i++) {
                    if(this.movie[i].open == 1) {
                        this.movie[i].open = true;
                    } else {
                        this.movie[i].open = false;
                    }
                }
                console.log(this.movie);
            });
            this.editVisible = true; 
        },
        setRoom() {
            adminUpdateStudyroom()
        },
        handleSearch2() {
            getFilm(this.Csearcher).then(res => {
                this.Msearcher = res.data[0];
                getFilmByID(this.Msearcher).then(res => {
                    this.query = res.data[0];
                });
            });
            this.editVisible = true;
        },
        handleAdd() {
            this.editVisible = true;
            this.editOrNot = 2;
        },
        handleDelete(index, row) {
            var un = localStorage.getItem('ms_username');
            if (un == 'admin') {
                this.$confirm('确定要删除吗？', '提示', {
                    type: 'warning'
                })
                    .then(() => {
                        this.$message.success('删除成功');
                        this.query = row;
                        this.movie.splice(index, 1);
                        deleteCinema(this.query);
                    })
                    .catch(() => { });
            } else {
                this.$message.warning("权限不足");
            }
        },
        handleCheck(index, row, rid) {
            this.Rsearcher.rid = rid;
            getAllSeat(this.Rsearcher).then(res => {
            //    this.seatData = res.data;
               this.showsth = res.seats;
            //    this.seatIn
            });
            this.seatVisible = true;
        },
        changesid() {
            this.orderInfo.scheduleId = this.scheduleID.scheduleId;
            this.handleCheck(0, 0);
            getSchuId(this.scheduleID).then(res => {
                this.showsth[0].schedule_price = res.data[0].schedule_price;
                this.showsth[0].hall_id = 1;
                this.Msearcher.filmId = res.data[0].film_id;
                getFilmByID(this.Msearcher).then(res => {
                    this.showsth[0].film_name = res.data[0].overnight;
                });
                this.Csearcher.cinemaId = res.data[0].cinema_id;
                getCinema(this.Csearcher).then(res => {
                    this.showsth[0].cinema_name = res.data[0].cinema_name;
                });
                // this.scheduleInfo.splice(0, 1, res.data[0]);
            });
        },
        seatSearch() {
            getSeatInfo(this.Ssearcher).then(res => {
                // this.seatIn = res.seat;
                console.log(res);
                this.seatIn[0] = res.seat;
                console.log(this.seatIn);
                this.seatSearchVisible = true;
                // this.seatIn.splice(0, 1, res.seat[0]);
            });
        },
        handleSelectionChange(val) {
            this.multipleSelection = val;
        },
        delAllSelection() {
            const length = this.multipleSelection.length;
            let str = '';
            this.delList = this.delList.concat(this.multipleSelection);
            for (let i = 0; i < length; i++) {
                str += this.multipleSelection[i].name + ' ';
            }
            this.$message.error(`删除了${str}`);
            this.multipleSelection = [];
        },
        handleEdit(index, row) {
            var un = localStorage.getItem('ms_username');
            if (un == 'admin') {
                this.idx = index;
                this.query = row;
                this.editVisible = true;
                this.editOrNot = 1;
            } else {
                this.$message.warning("权限不足");
            }

        },
        chooseSeat() {
            console.log(this.orderInfo);
            insertOrder(this.orderInfo).then(res => {
                if (res.code == 100) {
                    this.$message.success(res.msg);
                } else {
                    this.$message.error(res.msg);
                }
                this.$message.success("Success");
            });
        },
        saveEdit() {
            this.editVisible = false;
            //this.$message.success(`修改成功`);
            if (this.editOrNot == 1) {
                this.$set(this.movie, this.idx, this.query);
                //adminSetStudyroom(this.query);
                adminUpdateStudyroom(this.query);
            }
            //} else if (this.editOrNot == 2) {
            //    this.movie.push(this.query);
            //    insertFilm(this.query);
            //    this.clearer();
            //}
            this.editOrNot = 0;
            this.clearer();
        },
        handlePageChange(val) {
            this.$set(this.query, 'pageIndex', val);
            this.getData();
        }
    }
};
</script>

<style scoped>
.handle-box {
    margin-bottom: 20px;
}

.handle-select {
    width: 120px;
}

.handle-input {
    width: 150px;
    display: inline-block;
}

.table {
    width: 100%;
    font-size: 14px;
}

.red {
    color: #ff0000;
}

.mr10 {
    margin-right: 10px;
}

.table-td-thumb {
    display: block;
    margin: auto;
    width: 40px;
    height: 40px;
}
</style>
