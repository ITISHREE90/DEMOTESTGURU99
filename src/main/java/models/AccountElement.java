package models;

public class AccountElement {

    public String ele_label_account_title = "xpath:::.//p[@class='heading3']";
    
    public String ele_label_cus_id = "xpath:::.//input[@name='cusid']/parent::td/preceding-sibling::td";
    public String ele_input_cus_id = "xpath:::.//input[@name='cusid']";
    public String ele_label_dropdown_account_type = "xpath:::.//select[@name='selaccount']/parent::td/preceding-sibling::td";
    public String ele_dropdown_account_type = "xpath:::.//select[@name='selaccount']";
    public String ele_label_init_deposit = "xpath:::.//input[@name='inideposit']/parent::td/preceding-sibling::td";
    public String ele_input_init_deposit = "xpath:::.//input[@name='inideposit']";
    public String ele_btn_submit = "xpath:::.//input[@value='submit']";
    public String ele_btn_reset = "xpath:::.//input[@value='reset']";

    // Table to add a new Account successfully
    public String ele_label_created_acc_detail = "xpath:::.//tr[2]/td";
    public String ele_label_table_acc_id_value = "xpath:::.//td[text()='Account ID']/following-sibling::td";
    public String ele_label_table_cus_id_value = "xpath:::.//td[text()='Customer ID']/following-sibling::td";
    public String ele_label_table_cus_name_value = "xpath:::.//td[text()='Customer Name']/following-sibling::td";
    public String ele_label_table_cus_email_value = "xpath:::.//td[text()='Email']/following-sibling::td";
    public String ele_label_table_acc_type_value = "xpath:::.//td[text()='Account Type']/following-sibling::td";
    public String ele_label_table_acc_date_opening_value = "xpath:::.//td[text()='Date of Opening']/following-sibling::td";
    public String ele_label_table_acc_current_amount_value = "xpath:::.//td[text()='Current Amount']/following-sibling::td";

}