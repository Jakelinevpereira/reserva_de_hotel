package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reserva {
	private Integer numeroDoQuarto;
	private Date checkIn;
	private Date checkOut;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reserva(Integer numeroDoQuarto, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("A data de check-out deve ser posterior � data de check-in!");
		}
		this.numeroDoQuarto = numeroDoQuarto;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getNumeroDoQuarto() {
		return numeroDoQuarto;
	}

	public void setNumeroDoQuarto(Integer numeroDoQuarto) {
		this.numeroDoQuarto = numeroDoQuarto;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duracao() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

	public void updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("As datas de reserva para atualiza��o devem ser futuras!");
		}
		if(!checkOut.after(checkIn)) {
			throw new DomainException("A data de check-out deve ser posterior � data de check-in!");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
	}

	@Override
	public String toString() {
		return "Reserva numero Do Quarto:" + numeroDoQuarto + ", checkIn:" + sdf.format(checkIn) + ", checkOut:"
				+ sdf.format(checkOut) + ", " + duracao() + " Noite";
	}

}
