<template>
    <div>
        <div class="crumbs">
            <el-breadcrumb separator="/">
                <el-breadcrumb-item>
                    <i class="el-icon-lx-cascades"></i> 抢位
                </el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <el-form ref="form" :model="qiangweiInfo" label-width="70px">
            <el-form-item label="自习室号">
                <el-input v-model="qiangweiInfo.rid"></el-input>
            </el-form-item>
            <el-form-item label="座位号">
                <el-input v-model="qiangweiInfo.zid"></el-input>
            </el-form-item>
            <el-form-item label="开始时间">
                <el-input v-model="qiangweiInfo.starttime"></el-input>
            </el-form-item>
            <el-form-item label="结束时间">
                <el-input v-model="qiangweiInfo.endtime"></el-input>
            </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
            <el-button type="primary" @click="saveEdit">确 定</el-button>
        </span>
    </div>
</template>

<script>
import { takePosition } from '../../api/index';
export default {
    name: 'basetable',
    data() {
        return {
            qiangweiInfo: {
                rid : 1,
                zid : 1,
                starttime : 10,
                endtime : 11,
                sid : 222101
            },
        };
    },
    methods: {
        saveEdit() {
            this.qiangweiInfo.sid = localStorage.getItem('local_sid');
            takePosition(this.qiangweiInfo).then(res => {
                var code = res.code;
                if(code == 0) {
                    this.$message.success(res.msg);
                } else {
                    this.$message.warning(res.msg);
                }
            });
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
