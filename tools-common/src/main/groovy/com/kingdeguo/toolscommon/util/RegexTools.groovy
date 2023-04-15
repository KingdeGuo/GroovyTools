package com.kingdeguo.toolscommon.util

class RegexTools {

    /**
     * 验证手机号
     * @param phone
     * @return
     */
    static boolean validate(String phone) {
        def pattern = /^1[0-9]{10}$/
        return (phone =~ pattern).matches()
    }

    /**
     * 验证邮箱
     * @param email
     * @return
     */
    static boolean validateEmail(String email) {
        def pattern = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/;
        return (email =~ pattern).matches()
    }

    /**
     * 验证身份证号
     * @param idCard
     * @return
     */
    static boolean validateIdCard(String idCard) {
        def pattern = /(^\d{15}$)|(^\d{18}$)|(^\d{17}(\d|X|x)$)/;
        return (idCard =~ pattern).matches()
    }

    /**
     * 验证密码
     * @param password
     * @return
     */
    static boolean validatePassword(String password) {
        def pattern = /^[a-zA-Z0-9]{6,16}$/;
        return (password =~ pattern).matches()
    }

    /**
     * 验证用户名
     * @param username
     * @return
     */
    static boolean validateUsername(String username) {
        def pattern = /^[a-zA-Z0-9]{6,16}$/;
        return (username =~ pattern).matches()
    }

    /**
     * 验证中文
     * @param chinese
     * @return
     */
    static boolean validateChinese(String chinese) {
        def pattern = /^[\u4e00-\u9fa5]{0,}$/;
        return (chinese =~ pattern).matches()
    }

    /**
     * 验证URL
     * @param url
     * @return
     */
    static boolean validateUrl(String url) {
        def pattern = /^((https|http|ftp|rtsp|mms)?:\/\/)[^\s]+/;
        return (url =~ pattern).matches()
    }

    /**
     * 验证IP
     * @param ip
     * @return
     */
    static boolean validateIp(String ip) {
        def pattern = /((25[0-5]|2[0-4]\d|[01]?\d\d?)($|(?!\.$)\.)){4}/;
        return (ip =~ pattern).matches()
    }

    /**
     * 验证日期
     * @param date
     * @return
     */
    static boolean validateDate(String date) {
        def pattern = /^(\d{4})-(\d{2})-(\d{2})$/;
        return (date =~ pattern).matches()
    }

    /**
     * 验证时间
     * @param time
     * @return
     */
    static boolean validateTime(String time) {
        def pattern = /^(\d{2}):(\d{2}):(\d{2})$/;
        return (time =~ pattern).matches()
    }

    /**
     * 验证日期时间
     * @param dateTime
     * @return
     */
    static boolean validateDateTime(String dateTime) {
        def pattern = /^(\d{4})-(\d{2})-(\d{2}) (\d{2}):(\d{2}):(\d{2})$/;
        return (dateTime =~ pattern).matches()
    }

    /**
     * 验证数字
     * @param number
     * @return
     */
    static boolean validateNumber(String number) {
        def pattern = /^[0-9]*$/;
        return (number =~ pattern).matches()
    }

    /**
     * 验证数字
     * @param number
     * @return
     */
    static boolean validateNumber(String number, int min, int max) {
        def pattern = /^[0-9]*$/;
        return (number =~ pattern).matches() && number.toInteger() >= min && number.toInteger() <= max
    }

    /**
     * 验证地址
     * @param number
     * @return
     */
    static boolean validateAddress(String address) {
        def pattern = /^[\u4e00-\u9fa5_a-zA-Z0-9]+$/;
        return (address =~ pattern).matches()
    }

    /**
     * 验证金额
     * @param money
     * @return
     */
    static boolean validateMoney(String money) {
        def pattern = /^(([1-9]\d*)|\d)(\.\d{1,2})?$/;
        return (money =~ pattern).matches()
    }

}
