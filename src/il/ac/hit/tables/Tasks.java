package il.ac.hit.tables;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import il.ac.hit.tables.Users;


/**
 * this class implements all changes we want to make for our task  in our DB.
 * @author 89leo
 *
 */
	
	@Entity
	@Table(name="items")
	public class Tasks {
		@Id
		@Column(name="ID",nullable=false)
		@GeneratedValue
		private int id;
		@ManyToOne
		@JoinColumn(name = "NAME", nullable=false)
		private Users user;
		@Column(name="TASK")
		private String task;
		@Column(name="DATE")
		private Date date;
		@Column(name="STATUS")
		private String status;
		/**
		 * default contructor
		 */
		public Tasks() {
			
		}
		/**
		 * 
		 * @param task
		 * @param status
		 * @param user
		 * @param date
		 */
		public Tasks(String task,String status,Users user,Date date) {
			this.task = task;
			this.status = status;
			this.user = user;
			this.date = date;
		}
		/**
		 * 
		 * @return id of the user
		 */
		public int getId() {
			return id;
		}
/**
 * sets id 
 * @param id
 */
		public void setId(int id) {
			this.id = id;
		}
/**
 * 
 * @return user
 */
		public Users getUser() {
			return user;
		}
/**
 * sets user
 * @param user
 */
		public void setUser(Users user) {
			this.user = user;
		}
/**
 * 
 * @return task
 */
		public String getTask() {
			return task;
		}
/**
 * sets new task
 * @param task
 */
		public void setTask(String task) {
			this.task = task;
		}
/**
 * gets date of task to be completed
 * @return date
 */
		public Date getDate() {
			return date;
		}
/**
 * sets date to task 
 * @param date
 */
		public void setDate(Date date) {
			this.date = date;
		}
/**
 * get status of the task (not started/in progress/50%/completed)
 * @return status
 */
		public String getStatus() {
			return status;
		}
/**
 * change status of the task
 * @param status
 */
		public void setStatus(String status) {
			this.status = status;
		}
}
