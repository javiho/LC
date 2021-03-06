package my.vaadin.app;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Life {

	private LocalDate birth;
	private LocalDate death;
	private List<Note> notes;
	private Set<String> categories;
	
	private static LocalDate defaultBirth = LocalDate.of(1960, 1, 1);
	private static LocalDate defaultDeath = LocalDate.of(2020, 1, 1);
	
	public Life(){
		birth = defaultBirth;
		death = defaultDeath;
		notes = new ArrayList<>();
	}

	public LocalDate getStartByResolutionUnit(ChronoUnit resolutionUnit){
		return birth.with(TemporalAdjusters.previousOrSame(DayOfWeek.MONDAY));
	}
	
	public LocalDate getEndByResolutionUnit(ChronoUnit resolutionUnit){
		return death.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
	}
	
	public LocalDate getBirth() {
		return birth;
	}

	public void setBirth(LocalDate birth) {
		this.birth = birth;
	}

	public LocalDate getDeath() {
		return death;
	}

	public void setDeath(LocalDate death) {
		this.death = death;
	}

	public List<Note> getNotes() {
		return notes;
	}

	public void setNotes(List<Note> notes) {
		this.notes = notes;
	}

	public Set<String> getCategories() {
		return categories;
	}

	public void setCategories(Set<String> categories) {
		this.categories = categories;
	}
	
	
	
}
