<template>
    <div class="login-wrap">
        <div class="ms-login">
            <div class="ms-title">自习室管理系统</div>
            <el-form :model="param" :rules="rules" ref="login" label-width="0px" class="ms-content">
                <el-form-item prop="username">
                    <el-input v-model="param.sid" placeholder="学号">
                        <el-button slot="prepend" icon="el-icon-lx-people"></el-button>
                    </el-input>
                </el-form-item>
                <el-form-item prop="password">
                    <el-input type="password" placeholder="密码" v-model="param.password"
                        @keyup.enter.native="submitForm()">
                        <el-button slot="prepend" icon="el-icon-lx-lock"></el-button>
                    </el-input>
                </el-form-item>
                <div class="login-btn">
                    <el-button type="primary" @click="submitForm()">登录</el-button>
                </div>
                <div class="login-btn">
                    <el-button type="primary" @click="do_register()">注册</el-button>
                </div>
                <div class="login-btn">
                    <el-button type="primary" @click="AdminsubmitForm()">管理员登录</el-button>
                </div>
            </el-form>

            <el-dialog title="学生注册" :visible.sync="registerVisible" width="30%">
                <el-form ref="form" :model="User" label-width="70px">
                    <el-form-item label="学号">
                        <el-input v-model="User.sid"></el-input>
                    </el-form-item>
                    <el-form-item label="姓名">
                        <el-input v-model="User.sname"></el-input>
                    </el-form-item>
                    <el-form-item label="密码">
                        <el-input v-model="User.password"></el-input>
                    </el-form-item>
                    <el-form-item label="邮箱">
                        <el-input v-model="User.email"></el-input>
                    </el-form-item>
                    <el-form-item label="电话">
                        <el-input v-model="User.phone"></el-input>
                    </el-form-item>
                </el-form>
                <span slot="footer" class="dialog-footer">
                    <el-button @click="registerVisible = false">取 消</el-button>
                    <el-button @click="saveEdit">注 册</el-button>
                </span>
            </el-dialog>
        </div>
    </div>
</template>



<script>
import { manageLogin, manageRegister } from '../../api/index';
export default {
    data: function () {
        return {
            param: {
                sid: '222101',
                password: '123456'
            },
            rules: {
                sid: [{ required: true, message: '请输入用户名', trigger: 'blur' }],
                password: [{ required: true, message: '请输入密码', trigger: 'blur' }],
            },
            registerVisible: false,
            User: {
                sid: "183",
                sname: "shb",
                password: "123456",
                email: "@qq.com",
                phone: "10086",
                // userHeadimg: null
            }

        };
    },
    methods: {
        submitForm() {
            manageLogin(this.param).then(res => {
                this.$message.success('登录成功');
                localStorage.setItem('local_sid', this.param.sid);
                // localStorage.setItem('token', res.data.userPermission);
                this.$router.push('/');
            }).catch(err => {
                this.$message.error('登录失败');
            })
        },
        AdminsubmitForm() {
            adminLogin(this.param).then(res => {
                this.$message.success('登录成功');
                localStorage.setItem('local_sid', this.param.sid);
                // localStorage.setItem('token', res.data.userPermission);
                this.$router.push('/studyroom');
            }).catch(err => {
                this.$message.error('登录失败');
            })
        },
        // AdminsubmitForm() {
        //     this.$router.push('/studyroom');
        // },
        do_register() {
            this.registerVisible = true;
        },
        saveEdit() {
            this.registerVisible = false;
            manageRegister(this.User).then(res => {
                this.$message.success(res.msg);
            })
        }
    },
};
</script>

<style scoped>
.login-wrap {
    position: relative;
    width: 100%;
    height: 100%;
    background-image: url(../../assets/img/login-bg.jpg);
    background-size: 100%;
}

.ms-title {
    width: 100%;
    line-height: 50px;
    text-align: center;
    font-size: 20px;
    color: #fff;
    border-bottom: 1px solid #ddd;
}

.ms-login {
    position: absolute;
    left: 50%;
    top: 50%;
    width: 350px;
    margin: -190px 0 0 -175px;
    border-radius: 5px;
    background: rgba(255, 255, 255, 0.3);
    overflow: hidden;
}

.ms-content {
    padding: 30px 30px;
}

.login-btn {
    text-align: center;
}

.login-btn button {
    width: 100%;
    height: 36px;
    margin-bottom: 10px;
}

.login-tips {
    font-size: 12px;
    line-height: 30px;
    color: #fff;
}
</style>