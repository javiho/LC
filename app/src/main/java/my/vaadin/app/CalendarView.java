package my.vaadin.app;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class CalendarView extends VerticalLayout{
	
	private Life life;
	private ChronoUnit resolutionUnit;
	
	public CalendarView(){
		super();
		this.addComponent(new Label("This is a Calendar View"));
	}
	
	public void updateView(){
		// create boxes
		int boxCount = 0;
		System.out.println(life.getStartByResolutionUnit(resolutionUnit));
		System.out.println(life.getEndByResolutionUnit(resolutionUnit));
		for(LocalDate d = life.getStartByResolutionUnit(resolutionUnit);
				d.compareTo(life.getEndByResolutionUnit(resolutionUnit)) <= 0;
				//TOIMIIKO?
				d = this.firstDayOfNextResolutionUnit(d)){
			TimeUnitBox tob = new TimeUnitBox();
			this.addComponent(tob);
			boxCount++;
		}
		System.out.println("Boxes displayed: " + boxCount);
		// assign notes to boxes
		for(Note note : life.getNotes()){
			List<TimeUnitBox> tobs = getTobsByInterval(note.getStartDate(), note.getEndDate());
			for(TimeUnitBox tob : tobs){
				tob.addNote(note);
			}
		}
	}
	
	private List<TimeUnitBox> getTobsByInterval(LocalDate start, LocalDate end){
		ArrayList<TimeUnitBox> tobs = new ArrayList<>();
		for(Iterator<Component> componentIter = this.iterator(); componentIter.hasNext();){
			TimeUnitBox tob = (TimeUnitBox)componentIter.next();
			if(start.compareTo(tob.getStart()) > -1
					&& end.compareTo(tob.getEnd()) < 1){
				tobs.add(tob);
			}
		}
		return tobs;
	}
	
	private LocalDate firstDayOfNextResolutionUnit(LocalDate date){
		if(resolutionUnit.equals(ChronoUnit.DAYS)){
			return date.plusDays(1);
		}
		if(resolutionUnit.equals(ChronoUnit.WEEKS)){
			return date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
		}
		if(resolutionUnit.equals(ChronoUnit.MONTHS)){
			return date.with(TemporalAdjusters.firstDayOfNextMonth());
		}
		if(resolutionUnit.equals(ChronoUnit.YEARS)){
			return date.with(TemporalAdjusters.firstDayOfNextYear());
		}
		assert false;
		return date;
	}

	public Life getLife() {
		return life;
	}

	public void setLife(Life life) {
		this.life = life;
	}

	public ChronoUnit getResolutionUnit() {
		return resolutionUnit;
	}

	public void setResolutionUnit(ChronoUnit resolutionUnit) {
		this.resolutionUnit = resolutionUnit;
	}
	
}
