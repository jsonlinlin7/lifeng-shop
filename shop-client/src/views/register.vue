<template>
    <div class="header-container">
            <top-nav></top-nav>
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="手机号码" prop="phone">
                <el-input  v-model="ruleForm.phone" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="用户名" prop="username">
                <el-input  v-model="ruleForm.username" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="secondPassword">
                <el-input type="password" v-model="ruleForm.secondPassword" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    export default {
        name: "register",
        components: {
            "top-nav": () => import("@/components/TopNav"),
        },
        data() {
            var validatePhone = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('手机号码'));
                }
            };
            var validateUsername = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入用户名'));
                }
            };
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    if (this.ruleForm.secondPassword !== '') {
                        this.$refs.ruleForm.validateField('checkPass');
                    }
                    callback();
                }
            };

            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.ruleForm.password) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return {
                ruleForm: {
                    phone: '',
                    username: '',
                    password: '',
                    secondPassword: '',
                },
                rules: {
                    phone: [
                        { validator: validatePhone, trigger: 'blur' }
                    ],
                    username: [
                        { validator: validateUsername, trigger: 'blur' }
                    ],
                    password: [
                        { validator: validatePass, trigger: 'blur' }
                    ],secondPassword: [
                        { validator: validatePass2, trigger: 'blur' }
                    ],

                }
            };
        },
        methods: {
            submitForm(formName) {
                this.axios({
                    url: 'http://localhost:8084/shopuser/register',
                    method: "post",    //方式
                    data:{
                        phone : this.ruleForm.phone,
                        username : this.ruleForm.username,
                        password : this.ruleForm.password,
                        secondPassword : this.ruleForm.secondPassword
                    }
                }).then(res =>{
                    let resp = res.data;
                    if(resp.code==200){
                        this.$message({
                            message: resp.message,
                            type: 'success'
                        });

                    }else{
                        this.$message({
                            message: resp.message,
                            type: 'warning'
                        });
                    }
                })
                this.$refs[formName].resetFields();
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        }
    }
</script>


<style scoped>

</style>