package models;

public class CustomerElement {

    public String ele_label_new_customer_title = "xpath::://p[@class='heading3']";
    
    public String ele_label_cus_name = "xpath:::.//input[@name='name']/parent::td/preceding-sibling::td";
    public String ele_input_cus_name = "xpath:::.//input[@name='name']";
    public String ele_lbl_cus_gender = "xpath:::.//input[@value='m']/parent::td/preceding-sibling::td";
    public String ele_input_cus_gender_m = "xpath:::.//input[@name='rad1'][@value='m']";
    public String ele_input_cus_gender_f = "xpath:::.//input[@name='rad1'][@value='f']";
    public String ele_input_cus_gender = "xpath:::.//input[@name='rad1'][@value='%s']";

    public String ele_label_cus_birth_day = "xpath:::.//input[@id='dob']/parent::td/preceding-sibling::td";
    public String ele_input_cus_birth_day = "xpath:::.//input[@id='dob']";
    public String ele_label_cus_address = "xpath:::.//textarea[@name='addr']/parent::td/preceding-sibling::td";
    public String ele_input_cus_address = "xpath:::.//textarea[@name='addr']";
    public String ele_label_cus_city = "xpath:::.//input[@name='city']/parent::td/preceding-sibling::td";
    public String ele_input_cus_city = "xpath:::.//input[@name='city']";
    public String ele_label_cus_state = "xpath:::.//input[@name='state']/parent::td/preceding-sibling::td";
    public String ele_input_cus_state = "xpath:::.//input[@name='state']";
    public String ele_label_cus_pin = "xpath:::.//input[@name='pinno']/parent::td/preceding-sibling::td";
    public String ele_input_cus_pin = "xpath:::.//input[@name='pinno']";
    public String ele_label_cus_telephone = "xpath:::.//input[@name='telephoneno']/parent::td/preceding-sibling::td";
    public String ele_input_cus_telephone = "xpath:::.//input[@name='telephoneno']";
    public String ele_label_cus_email = "xpath:::.//input[@name='emailid']/parent::td/preceding-sibling::td";
    public String ele_input_cus_email = "xpath:::.//input[@name='emailid']";
    public String ele_label_cus_password = "xpath:::.//input[@name='password']/parent::td/preceding-sibling::td";
    public String ele_input_cus_password = "xpath:::.//input[@name='password']";
    public String ele_btn_submit = "xpath:::.//input[@value='Submit']";
    public String ele_btn_reset = "xpath:::.//input[@value='Reset']";

    // Table add new Customer successfully
    public String ele_label_registered_cus_detail = "xpath:::.//tr[2]/td";
    public String ele_label_table_cus_id_value = "xpath:::.//td[text()='Customer ID']/following-sibling::td";
    public String ele_label_table_cus_name_value = "xpath:::.//td[text()='Customer Name']/following-sibling::td";
    public String ele_label_table_cus_gender_value = "xpath:::.//td[text()='Gender']/following-sibling::td";
    public String ele_label_table_cus_birth_date_value = "xpath:::.//td[text()='Birthdate']/following-sibling::td";
    public String ele_label_table_cus_address_value = "xpath:::.//td[text()='Address']/following-sibling::td";
    public String ele_label_table_cus_city_value = "xpath:::.//td[text()='City']/following-sibling::td";
    public String ele_label_table_cus_state_value = "xpath:::.//td[text()='State']/following-sibling::td";
    public String ele_label_table_cus_pin_value = "xpath:::.//td[text()='Pin']/following-sibling::td";
    public String ele_label_table_cus_telephone_value = "xpath:::.//td[text()='Mobile No.']/following-sibling::td";
    public String ele_label_table_cus_email_value = "xpath:::.//td[text()='Email']/following-sibling::td";

}