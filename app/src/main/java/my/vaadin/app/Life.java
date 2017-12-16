package my.vaadin.app;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public class Life {

	private LocalDate birth;
	private LocalDate death;
	private List<Note> notes;
	private Set<String> categories;
	
	private static LocalDate defaultBirth = LocalDate.of(1960, 0, 0);
	private static LocalDate defaultDeath = LocalDate.of(2020, 0, 0);
	
	public Life(){
		birth = defaultBirth;
		death = defaultDeath;
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