package models;

public class DepositElement {

    public String ele_label_deposit_title = "xpath:::.//p[@class='heading3']";
    public String ele_label_acc_id = "xpath:::.//input[@name='accountno']/parent::td/preceding-sibling::td";
    public String ele_input_acc_id = "xpath:::.//input[@name='accountno']";
    public String ele_label_amount = "xpath:::.//input[@name='ammount']/parent::td/preceding-sibling::td";
    public String ele_input_amount = "xpath:::.//input[@name='ammount']";
    public String ele_label_description = "xpath:::.//input[@name='desc']/parent::td/preceding-sibling::td";
    public String ele_input_description = "xpath:::.//input[@name='desc']";
    public String ele_btn_submit = "xpath:::.//input[@value='Submit']";
    public String ele_btn_reset = "xpath:::.//input[@value='Reset']";

    // Table to add new Transaction successfully
    public String ele_label_table_transaction_id_value = "xpath:::.//td[text()='Transaction ID']/following-sibling::td";
    public String ele_label_table_acc_id_value = "xpath:::.//td[text()='Account No']/following-sibling::td";
    public String ele_label_table_amount_value = "xpath:::.//td[text()='Amount Credited']/following-sibling::td";
    public String ele_label_table_type_transaction_value = "xpath:::.//td[text()='Type of Transaction']/following-sibling::td";
    public String ele_label_table_description_value = "xpath:::.//td[text()='Description']/following-sibling::td";
    public String ele_label_table_current_balance_value = "xpath:::.//td[text()='Current Balance']/following-sibling::td";

}