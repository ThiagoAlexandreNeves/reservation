package testing.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import testing.exception.DomainException;

public class Reservation {

	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private int number;
	private Date checkIn;
	private Date checkOut;

	public Reservation(int number, Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if (!checkOut.after(checkIn)) {
			throw new DomainException("CheckOut não é uma data futura ao checkIn");
		}
		if (checkIn.before(now) || checkOut.after(now)) {
			throw new DomainException("Data anterior a atual");
		}
		this.number = number;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public void update(Date checkIn, Date checkOut) throws DomainException {
		Date now = new Date();
		if (!checkOut.after(checkIn)) {
			throw new DomainException("CheckOut não é uma data futura ao checkIn");
		}
		if (checkIn.before(now) || checkOut.after(now)) {
			throw new DomainException("Data anterior a atual");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	@Override
	public String toString() {
		return "Reservation: number " + number + ", " + "checkIn " + checkIn + ", "
				+ "" + "checkOut " + checkOut + ", " + duration() + " nights";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
}
