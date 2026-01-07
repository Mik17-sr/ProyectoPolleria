package com.mycompany.Utility;

import com.toedter.calendar.JDateChooser;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.time.temporal.IsoFields;

public class FechaUtil {

    public static RangoFecha rangoPorAnio(int anio) {
        LocalDate inicio = LocalDate.of(anio, 1, 1);
        LocalDate fin = LocalDate.of(anio, 12, 31);
        return new RangoFecha(inicio, fin);
    }
    
    public static RangoFecha rangoPorMes(int anio, int mes) {
        YearMonth ym = YearMonth.of(anio, mes);
        return new RangoFecha(
            ym.atDay(1),
            ym.atEndOfMonth()
        );
    }
    
    public static RangoFecha rangoPorSemana(int anio, int semana) {
        LocalDate inicio = LocalDate.of(anio, 1, 1)
            .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, semana)
            .with(DayOfWeek.MONDAY);
        return new RangoFecha(inicio, inicio.plusDays(6));
    }
    
}
