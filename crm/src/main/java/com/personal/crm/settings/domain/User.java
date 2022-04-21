package com.personal.crm.settings.domain;

/**
 * packageName: com.personal.crm.settings.domain
 * className: User
 * description:
 *
 * @Author: UltraHerry
 * @Date: 2022/4/21 19:38
 */
public class User {

    /**
     * 关于字符串表示的日期和时间
     * 市场上常用表示方式有两种
     *      日期：年-月-日，yyyy-MM-dd,10位字符串，使用char(10)，效率较高
     *      日期加时间：年-月-日 时:分:秒，yyyy-MM-dd HH-mm-ss，19位字符串
     */

    /**
     * 关于登录
     *      验证账号和密码
     *      使用select * from t_user where loginAct = ? and loginPwd = ?
     *      不建议使用count(*)，因为我们需要其他字段的数据进行验证
     *      返回值为null则说明无此账号或密码不正确
     *      否则说明账号密码正确，需要继续验证其他数据
     *      expireTime：验证失效时间
     *      lockState：验证锁定状态，是否允许登录
     *      allowIps：验证登陆方的ip地址是否允许访问
     *
     * 使用自定义异常的方式
     *      账号不存在或密码错误：user=null
     *      账号已失效：expireTime
     *      账号已锁定：lockState
     *      ip不允许访问：allowIps
     */
    private String id; //主键
    private String loginAct;//登陆账号
    private String name ;//用户真实姓名
    private String loginPwd;//登录密码
    private String email;//邮箱
    private String expireTime;//失效时间
    private String lockState;//锁定状态：0表示锁定，1表示启用
    private String deptno;//部门编号
    private String allowIps;//允许访问的ip
    private String createTime;//创建时间
    private String createBy;//创建人
    private String editTime;//修改时间
    private String editBy;//修改人

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginAct() {
        return loginAct;
    }

    public void setLoginAct(String loginAct) {
        this.loginAct = loginAct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExpireTime() {
        return expireTime;
    }

    public void setExpireTime(String expireTime) {
        this.expireTime = expireTime;
    }

    public String getLockState() {
        return lockState;
    }

    public void setLockState(String lockState) {
        this.lockState = lockState;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    public String getAllowIps() {
        return allowIps;
    }

    public void setAllowIps(String allowIps) {
        this.allowIps = allowIps;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getEditTime() {
        return editTime;
    }

    public void setEditTime(String editTime) {
        this.editTime = editTime;
    }

    public String getEditBy() {
        return editBy;
    }

    public void setEditBy(String editBy) {
        this.editBy = editBy;
    }
}
