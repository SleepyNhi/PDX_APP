package pdx.module.admin;

public class Finance {
private int billId;
private int reservationId;
private double billTotal;
private char paid;
private int paymentDate;
private int creditCardHold;
private char creditCardPaid;
private char chargeType;
private double cost;
	public Finance(int billId, int reservationId , double billTotal, char paid, int paymentDate, int creditCardHold,char creditCardPaid,char chargeType,double cost)
			{
		this.billId = billId;
		this.reservationId = reservationId;
		this.billTotal = billTotal;
		this.paid = paid;
		this.paymentDate = paymentDate;
		this.creditCardHold = creditCardHold;
		this.creditCardPaid = creditCardPaid;
		this.chargeType = chargeType;
		this.cost = cost;		
			}
	public void setbillId(int billId){	
		this.billId = billId;
	}
	int getbillId(){
		return billId;
	}
	public void setreservationId(int reservationId){	
		this.reservationId = reservationId;
	}
	int getreservationId(){
		return reservationId;
	}
	public void setbillTotal(double billTotal){	
		this.billTotal = billTotal;
	}
	double getbillTotal(){
		return billTotal;
	}
	public void setpaid(char paid){	
		this.paid = paid;
	}
	char getpaid(){
		return paid;
	}
	public void setpaymentDate(int paymentDate){	
		this.paymentDate = paymentDate;
	}
	int getpaymentDate(){
		return paymentDate;
	}
	public void setcreditCardHold(int creditCardHold){	
		this.creditCardHold = creditCardHold;
	}
	int getcreditCardHoldl(){
		return creditCardHold;
	}
	public void setcreditCardPaid(char creditCardPaid){	
		this.creditCardPaid = creditCardPaid;
	}
	char getcreditCardPaidl(){
		return creditCardPaid;
	}
	public void setchargeType(char chargeType){	
		this.chargeType = chargeType;
	}
	char getchargeType(){
		return chargeType;
	}
	public void setcost(double cost){	
		this.cost = cost;
	}
	double getcost(){
		return cost;
	}
}
