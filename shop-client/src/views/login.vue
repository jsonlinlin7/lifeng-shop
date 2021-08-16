<template>
    <div class="header-container">
            <top-nav></top-nav>
        <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="用户名" prop="username">
                <el-input  v-model="ruleForm.username" autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item label="密码" prop="password">
                <el-input type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
                <el-button type="danger" @click="toregister()" round>立即注册</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>
<script>
    export default {
        name: "name",
        components: {
            "top-nav": () => import("@/components/TopNav"),
        },
        data() {
            var validateusername = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入用户名'));
                }
            };
            var validatepassword = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                }
            };
            return {
                ruleForm: {
                    username: '',
                    password: '',
                },
                rules: {
                    username: [
                        { validator: validateusername, trigger: 'blur' }
                    ],
                    password: [
                        { validator: validatepassword, trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {

                this.axios({
                    url: 'http://localhost:8084/shopuser/login',
                    method: "post",    //方式
                    data:{
                        username : this.ruleForm.username,
                        password : this.ruleForm.password
                    }
                }).then(res =>{
                    let resp = res.data;
                    if(resp.code===200){
                        this.$message({
                            message: '用户名密码正确，登录成功',
                            type: 'success'
                        });
                        this.$router.push({path:"/index",query:{islogin:"true"}})
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
            },
            toregister(){
              console.log("toRegister")
                this.$router.push('/register')
            }
        }
    }
</script>

<style scoped>


</style>
