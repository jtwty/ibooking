<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 预约记录
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="container">
            <div class="handle-box">
                <el-button type="primary" icon="el-icon-search" @click="get_Record">查看预定</el-button>
            </div>
            <el-table :data="orderInfo" border class="table" ref="multipleTable" header-cell-class-name="table-header">
                <el-table-column prop="id" label="预约号"  ></el-table-column>
                <el-table-column prop="sid" label="学号"></el-table-column>
                <el-table-column prop="zid" label="座位号"></el-table-column>
                <el-table-column prop="rid" label="自习室号"></el-table-column>
                <el-table-column prop="start_time" label="开始时间"></el-table-column>
                <el-table-column prop="end_time" label="结束时间"></el-table-column>
                <el-table-column prop="booking_date" label="预约日期"></el-table-column>
                <el-table-column prop="status" label="当前状态">
                    <template slot-scope="scope">
                        <h1 v-if="scope.row.status == 0">
                            <div style="font-size:12px">
                                待签到
                            </div>
                        </h1>
                        <h1 v-else-if="scope.row.status == 1">
                            <div style="font-size:12px">
                                已签到
                            </div>
                        </h1>
                        <h1 v-else>
                            <div style="font-size:12px">
                                已取消
                            </div>
                        </h1>
                    </template>
                </el-table-column>
                <el-table-column label="操作" width="180" align="center">
                    <template slot-scope="scope">
                        <div v-if="scope.row.status == 0">
                            <el-button type="text" icon="el-icon-edit"
                                @click="handleCancel(scope.$index, scope.row.id)">取消</el-button>
                            <el-button type="text" icon="el-icon-search"
                                @click="handleCheck(scope.$index, scope.row)">签到</el-button>
                        </div>
                        <div v-else>
                            <el-button type="text" icon="el-icon-edit"
                                @click="reAppointment(scope.$index, scope.row)">重新预约</el-button>
                        </div>
                    </template>
                </el-table-column>
            </el-table>
        </div>

        <el-dialog title="编辑" :visible.sync="editVisible" width="30%">
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
        </el-dialog>
    </div>
</template>

<script>
import { getRecord, deleteAppointment, seatSignin} from '../../api/index';
export default {
    name: 'basetable',
    data() {
        return {
            firstQuery: {
                sid: "1111",
            },
            canceler: {
                id: 1
            },
            checker: {
                sid: "1",
                zid: 1,
                rid: 1
            },
            orderInfo: [{
                id: 111,
                zid: 222,
                rid: 333,
                sid: 4,
                start_time: 0,
                end_time: 1,
                booking_date: 526,
                status: 0
            }, {
                id: 111,
                zid: 222,
                rid: 333,
                sid: 444,
                start_time: 0,
                end_time: 1,
                booking_date: 526,
                status: 1
            }],
            query: {
                id: 1111,
                zid: 2222,
                rid: 3333,
                sid: 4444,
                start_time: 2,
                end_time: 3,
                booking_date: 527,
                status: 1
            },
            inserter: {
                id: 11111,
                zid: 22222,
                rid: 33333,
                sid: 44444,
                start_time: 4,
                end_time: 5,
                booking_date: 528,
                status: 2
            },
            Appointmenter: {
                id: 1,//座位自增id
                starttime: 1,
                endtime: 2,
                today: 1,
                sid: 183
            },
            tableData: [],
            multipleSelection: [],
            delList: [],
            editVisible: false,
            resultVisible: false,
            pageTotal: 0,
            editOrNot: 1,
            form: {},
            idx: -1,
            id: -1
        };
        
    },
    created() {
        this.get_stuId();
        this.get_Record();
    },
    methods: {
        clearer() {
            this.query = this.inserter;
        },
        // get_stuId() {
        //     var stu_num = localStorage.getItem('local_sid');
        //     this.firstQuery.sid = stu_num;
        //     this.orderInfo[0].sid = stu_num;
        //     this.query.sid = stu_num;
        // },
        get_Record() {
            this.firstQuery.sid = localStorage.getItem('local_sid');
            getRecord(this.firstQuery).then(res => {
                this.orderInfo = res.records;
            })
        },
        handleCancel(index, id) {
            this.canceler.id = id;
            deleteAppointment(this.canceler).then(res => {
                this.$message.success(res.msg);
                if(res.code == 0) {
                    this.orderInfo[index].status = 2;
                }
            });
        },
        handleCheck(index, row) {
            this.query = row;
            this.checker.rid = this.query.rid;
            this.checker.sid = localStorage.getItem('local_sid');
            seatSignin(this.checker).then(res => {
                this.$message.success(res.msg);
                if(res.code == 0) {
                    this.orderInfo[index].status = 1;
                }
            });
        },
        reAppointment(id){
            this.$router.push('/seats');
        },
        saveEdit() {
            this.editVisible = false;
            this.$message.success(`修改成功`);
            if (this.editOrNot == 1) {
                this.$set(this.userInfo, this.idx, this.query);
                updateUserInfo(this.query);
            }
            this.editOrNot = 0;
            this.clearer();
        },
        handlePageChange(val) {
            this.$set(this.query, 'pageIndex', val);
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
    width: 200px;
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
