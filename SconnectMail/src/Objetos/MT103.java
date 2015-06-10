/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author PBCGJP
 */
public class MT103 {
    String SenderReference;
    String TimeIndication;
    String BankOperationCode;
    String InstructionCode;
    String TransactionTypeCode;
    Campo32 campo32;
    Campo33 campo33;
    String ExchangeRate;
    Client Ordering;
    Institucion SenderCorres;
    Institucion ReceiverCorres;
    Institucion Third;
    Institucion Intermediary;
    Institucion AccountWith;
    Client Beneficiary;
    String RemittanceInformation;
    String Charges;
    String Information;
    String Ack;
    String Receiver;

    public MT103() {
    }
    
    public MT103 (String data) {

        this.Ack = data.substring(data.indexOf("{1:F21")+6,data.indexOf("}"))+" Time: "+data.substring(data.indexOf("177:")+4, data.indexOf("177:")+14);
        this.SenderReference = data.substring(data.indexOf(":20:")+4,data.indexOf(":", data.indexOf(":20:")+4));
        this.campo32 = new Campo32(data.substring(data.indexOf(":32A:")+5,data.indexOf(":", data.indexOf(":32A:")+5)));
        this.Ordering = new Client(data.substring(data.indexOf(":50")+3, data.indexOf(":", data.indexOf(":50")+6)));
        this.Beneficiary = new Client(data.substring(data.indexOf(":59")+3, data.indexOf(":", data.indexOf(":59")+6)));
        this.RemittanceInformation = data.substring(data.indexOf(":70:")+4, data.indexOf(":", data.indexOf(":70:")+4));
        
    }

    public void setAck(String Ack) {
        this.Ack = Ack;
    }

    public String getAck() {
        return Ack;
    }

    public String getReceiver() {
        return Receiver;
    }

    public void setReceiver(String Receiver) {
        this.Receiver = Receiver;
    }
    
    public Institucion getAccountWith() {
        return AccountWith;
    }

    public String getBankOperationCode() {
        return BankOperationCode;
    }

    public Client getBeneficiary() {
        return Beneficiary;
    }

    public MT103(String SenderReference, String TimeIndication, String BankOperationCode, String InstructionCode, String TransactionTypeCode, Campo32 campo32, Campo33 campo33, String ExchangeRate, Client Ordering, Institucion SenderCorres, Institucion ReceiverCorres, Institucion Third, Institucion Intermediary, Institucion AccountWith, Client Beneficiary, String RemittanceInformation, String Charges, String Information) {
        this.SenderReference = SenderReference;
        this.TimeIndication = TimeIndication;
        this.BankOperationCode = BankOperationCode;
        this.InstructionCode = InstructionCode;
        this.TransactionTypeCode = TransactionTypeCode;
        this.campo32 = campo32;
        this.campo33 = campo33;
        this.ExchangeRate = ExchangeRate;
        this.Ordering = Ordering;
        this.SenderCorres = SenderCorres;
        this.ReceiverCorres = ReceiverCorres;
        this.Third = Third;
        this.Intermediary = Intermediary;
        this.AccountWith = AccountWith;
        this.Beneficiary = Beneficiary;
        this.RemittanceInformation = RemittanceInformation;
        this.Charges = Charges;
        this.Information = Information;
    }

    public Campo32 getCampo32() {
        return campo32;
    }

    public Campo33 getCampo33() {
        return campo33;
    }

    public String getCharges() {
        return Charges;
    }

    public String getExchangeRate() {
        return ExchangeRate;
    }

    public String getInformation() {
        return Information;
    }

    public String getInstructionCode() {
        return InstructionCode;
    }

    public Institucion getIntermediary() {
        return Intermediary;
    }

    public Client getOrdering() {
        return Ordering;
    }

    public Institucion getReceiverCorres() {
        return ReceiverCorres;
    }

    public String getRemittanceInformation() {
        return RemittanceInformation;
    }

    public Institucion getSenderCorres() {
        return SenderCorres;
    }

    public String getSenderReference() {
        return SenderReference;
    }

    public Institucion getThird() {
        return Third;
    }

    public String getTimeIndication() {
        return TimeIndication;
    }

    public String getTransactionTypeCode() {
        return TransactionTypeCode;
    }

    public void setAccountWith(Institucion AccountWith) {
        this.AccountWith = AccountWith;
    }

    public void setBankOperationCode(String BankOperationCode) {
        this.BankOperationCode = BankOperationCode;
    }

    public void setBeneficiary(Client Beneficiary) {
        this.Beneficiary = Beneficiary;
    }

    public void setCampo32(Campo32 campo32) {
        this.campo32 = campo32;
    }

    public void setCampo33(Campo33 campo33) {
        this.campo33 = campo33;
    }

    public void setCharges(String Charges) {
        this.Charges = Charges;
    }

    public void setExchangeRate(String ExchangeRate) {
        this.ExchangeRate = ExchangeRate;
    }

    public void setInformation(String Information) {
        this.Information = Information;
    }

    public void setInstructionCode(String InstructionCode) {
        this.InstructionCode = InstructionCode;
    }

    public void setIntermediary(Institucion Intermediary) {
        this.Intermediary = Intermediary;
    }

    public void setOrdering(Client Ordering) {
        this.Ordering = Ordering;
    }

    public void setReceiverCorres(Institucion ReceiverCorres) {
        this.ReceiverCorres = ReceiverCorres;
    }

    public void setRemittanceInformation(String RemittanceInformation) {
        this.RemittanceInformation = RemittanceInformation;
    }

    public void setSenderCorres(Institucion SenderCorres) {
        this.SenderCorres = SenderCorres;
    }

    public void setSenderReference(String SenderReference) {
        this.SenderReference = SenderReference;
    }

    public void setThird(Institucion Third) {
        this.Third = Third;
    }

    public void setTimeIndication(String TimeIndication) {
        this.TimeIndication = TimeIndication;
    }

    public void setTransactionTypeCode(String TransactionTypeCode) {
        this.TransactionTypeCode = TransactionTypeCode;
    }
    
    
    
    
    
                                    
            
}
