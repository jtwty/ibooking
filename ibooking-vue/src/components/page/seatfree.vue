<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 座位查询
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-input type="number" v-model="FreeSeatsearcher.rid" placeholder="自习室号"
                    class="handle-input mr10">
                </el-input>
                <el-input type="number" v-model="FreeSeatsearcher.starttime" placeholder="开始时间"
                    class="handle-input mr10">
                </el-input>
                <el-input type="number" v-model="FreeSeatsearcher.endtime" placeholder="结束时间"
                    class="handle-input mr10">
                </el-input>
                <el-input type="number" v-model="FreeSeatsearcher.today" placeholder="是否当日"
                    class="handle-input mr10">
                </el-input>
                <el-input type="number" v-model="SeatInfosearcher.id" placeholder="座位自增id" class="handle-input mr10">
                </el-input>
                <el-button type="primary" icon="el-icon-search" @click="getRoomSeat">查看自习室所有座位信息</el-button>
                <el-button type="primary" icon="el-icon-search" @click="lookforFreeSeat">查看指定时段空闲座位</el-button>
                <el-button type="primary" icon="el-icon-search" @click="get_SeatInfo">查看座位详细信息</el-button>
            </div>
            <el-table :data="seatInfo" border class="table" ref="multipleTable" header-cell-class-name="table-header">
                <!-- <el-table-column prop="id" label="座位自增id"></el-table-column> -->
                <el-table-column prop="zid" label="座位号"></el-table-column>
                <el-table-column prop="rid" label="自习室号"></el-table-column>
                <!-- <el-table-column prop="socket" label="是否有插座"></el-table-column> -->
                <el-table-column prop="osocket" label="是否有插座" align="center">
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
                <!-- <el-table-column prop="today_book" label="当日预约信息"></el-table-column>
                <el-table-column prop="next_book" label="次日预约信息"></el-table-column> -->


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


                <el-table-column label="操作" width="200" align="center">
                    <template slot-scope="scope">
                        <el-button type="text" icon="el-icon-search"
                            @click="handleAppointment(scope.$index, scope.row)">预定</el-button>
                    </template>
                </el-table-column>
            </el-table>
        </div>

        <!-- <el-dialog title="编辑" :visible.sync="editVisible" width="30%">
            <el-form ref="form" :model="query" label-width="70px">
                <el-form-item label="学号">
                    <el-input v-model="query.sid"></el-input>
                </el-form-item>
                <el-form-item label="姓名">
                    <el-input v-model="query.sname"></el-input>
                </el-form-item>
                <el-form-item label="密码">
                    <el-input v-model="query.password"></el-input>
                </el-form-item>
                <el-form-item label="邮箱">
                    <el-input v-model="query.email"></el-input>
                </el-form-item>
                <el-form-item label="电话">
                    <el-input v-model="query.phone"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer" class="dialog-footer">
                <el-button @click="editVisible = false">取 消</el-button>
                <el-button type="primary" @click="saveEdit">确 定</el-button>
            </span>
        </el-dialog> -->

    </div>
</template>

<script>
import { getSeatInfo , getAllSeat , getSeatFree , seatAppointment} from '../../api/index';
export default {
    name: 'basetable',
    data() {
        return {
            FreeSeatsearcher: {
                rid: 1,
                starttime: 1,
                endtime: 2,
                today: 1//是否查询当天
            },
            SeatInfosearcher: {
                id: 1
            },
            Appointmenter: {
                id: 1,//座位自增id
                starttime: 1,
                endtime: 2,
                today: 1,
                sid: "183"
            },
            seatInfo: [
            {
                id : 111,
                zid: 222,
                rid: 333,
                socket: 1,
                today_book: "111100001111000011110000",
                next_book : "111100001111000011110000",
            },
            {
                id : 111,
                zid: 222,
                rid: 333,
                socket: 1,
                today_book: "111100001111000011110000",
                next_book : "111100001111000011110000",
            }
            ],
            query: {
                id : 111,
                zid: 222,
                rid: 333,
                socket: 1,
                today_book: "111100001111000011110000",
                next_book : "111100001111000011110000",
            },
            inserter: {
                id : 111,
                zid: 222,
                rid: 333,
                socket: 1,
                today_book: "111100001111000011110000",
                next_book : "111100001111000011110000",
            },
            tableData: [],
            seatData: [],
            multipleSelection: [],
            delList: [],
            editVisible: false,
            resultVisible: false,
            seatVisible: false,
            pageTotal: 1,
            form: {},
            idx: -1,
            id: -1,
            editOrNot: 1,
            token: "user"
        };
    },
    created() {
        this.get_SeatInfo();
    },
    methods: {
        clearer() {
            this.query = this.inserter;
        }, 
        getRoomSeat(){
            //查询某自习室的所有座位信息
            this.rid = FreeSeatsearcher.rid;
            getAllSeat(this.rid),then(res =>{
                this.seatInfo = res.data[0];
            });
        },
        get_SeatInfo(){
            //根据座位自增id查到座位
            getSeatInfo(this.id).then(res => {
                this.seatInfo.splice(0, 1, res.data);
            });
        },
        lookforFreeSeat(){
            //查询指定时段空闲座位
            getSeatFree(this.FreeSeatsearcher).then(res => {
                this.seatInfo = res.data[0];
            });
        },
        handleAppointment(){
            this.Appointmenter.sid = localStorage.getItem('local_sid');
            this.Appointmenter.id = this.SeatInfosearcher.id;
            this.Appointmenter.starttime = this.FreeSeatsearcher.starttime;
            this.Appointmenter.endtime = this.FreeSeatsearcher.endtime;
            this.Appointmenter.today = this.FreeSeatsearcher.today;
            console.log(this.Appointmenter);
            seatAppointment(this.Appointmenter).then(res =>{
                this.$message.success('预定成功');
            })
        }

    }
    
}
</script>