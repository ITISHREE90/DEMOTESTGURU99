package models;

public class LoginElement {
    public String ele_label_user_id = "xpath:::.//input[@name='uid']/parent::td/preceding-sibling::td";
    public String ele_input_user_id = "xpath:::.//input[@name='uid']";
    public String ele_label_password = "xpath:::.//input[@name='password']/parent::td/preceding-sibling::td";
    public String ele_input_password = "xpath:::.//input[@name='password']";
    public String ele_btn_login = "xpath:::.//input[@name='btnLogin']";
    public String ele_btn_reset = "xpath:::.//input[@name='btnReset']";
}