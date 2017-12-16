package my.vaadin.app;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;

public class CalendarView extends VerticalLayout{
	
	private Life life;
	private Duration resolutionUnit;
	
	public CalendarView(){
		super();
	}
	
	public void updateView(){
		// create boxes
		for(LocalDate d = life.getBirth();
				d.compareTo(life.getDeath()) <= 0;
				d = d.plus(resolutionUnit)){
			TimeUnitBox tob = new TimeUnitBox();
			this.addComponent(tob);
		}
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

	public Life getLife() {
		return life;
	}

	public void setLife(Life life) {
		this.life = life;
	}

	public Duration getResolutionUnit() {
		return resolutionUnit;
	}

	public void setResolutionUnit(Duration resolutionUnit) {
		this.resolutionUnit = resolutionUnit;
	}
	
}
