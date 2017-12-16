package my.vaadin.app;

import java.time.Duration;
import java.time.LocalDate;

import com.vaadin.ui.VerticalLayout;

public class MainView extends VerticalLayout{

	private final CalendarView calendarView;
	
	private Life life;
	private Duration resolutionUnit;
	
	public MainView(){
		super();
		calendarView = new CalendarView();
		this.addComponent(calendarView);
	}
	
	public void initialize(Life life, Duration resolutionUnit){
		this.life = life;
		this.resolutionUnit = resolutionUnit;
		
		calendarView.setResolutionUnit(resolutionUnit);
		calendarView.setLife(life);
		calendarView.updateView();
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
