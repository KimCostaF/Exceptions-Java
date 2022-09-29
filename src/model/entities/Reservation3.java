package model.entities;

import model.exceptions.DomainExceptions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation3 {
    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation3(Integer roomNumber, Date checkIn, Date checkOut) throws DomainExceptions{
        if (!checkOut.after(checkIn)) {
            throw new DomainExceptions("ERRO AO FAZER A RESERVA: A DATA DE CHECKOUT DEVE SER APÓS A DATA DE " +
                    "CHECKIN");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) throws DomainExceptions{
        Date now = new Date();
        if (checkIn.before(now) || checkOut.before(now)) {
            throw new DomainExceptions(" AS DATAS PARA ATUALIZAR A RESERVA DEVEM SER DE DATAS" +
                    " FUTURAS A RESERVA ANTERIOR");

        }
        if (!checkOut.after(checkIn)) {
            throw new DomainExceptions(" A DATA DE CHECKOUT DEVE SER APÓS A DATA DE " +
                    "CHECKIN");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Quarto "
                + roomNumber
                + ", check-in: "
                + sdf.format(checkIn)
                + ", check-out: "
                + sdf.format(checkOut)
                + ", "
                + duration()
                + " Noites";

    }

}


