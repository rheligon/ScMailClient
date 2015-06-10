/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author PBCGJP
 */
public class Campo32 {
    int ValueDate;
    String Currency;
    Double Amount;

    public Campo32(int ValueDate, String Currency, Double Amount) {
        this.ValueDate = ValueDate;
        this.Currency = Currency;
        this.Amount = Amount;
    }

    public Campo32() {
    }
    
    public Campo32(String data){

        this.ValueDate =Integer.parseInt(data.substring(0, 6));
        this.Currency = data.substring(6,9);
        this.Amount = Double.valueOf(data.substring(9,data.length()-1).replace(",","."));
    }

    public Double getAmount() {
        return Amount;
    }

    public String getCurrency() {
        return Currency;
    }

    public int getValueDate() {
        return ValueDate;
    }

    public void setAmount(Double Amount) {
        this.Amount = Amount;
    }

    public void setCurrency(String Currency) {
        this.Currency = Currency;
    }

    public void setValueDate(int ValueDate) {
        this.ValueDate = ValueDate;
    }
    
    

}
