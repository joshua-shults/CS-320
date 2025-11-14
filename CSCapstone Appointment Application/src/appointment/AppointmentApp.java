package appointment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppointmentApp{
	
	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	
	public static void main(String[] args) {
		DATE_FORMAT.setLenient(false);
		
		Scanner scanner = new Scanner(System.in);
		
		AppointmentService appointmentService = new AppointmentService();
		ContactService contactService = new ContactService();
		TaskService taskService = new TaskService();
		
		boolean running = true;
		
		while (running) {
			printMainMenu();
			System.out.print("Enter Choice:");
			String choice = scanner.nextLine().trim();
			
			switch (choice) {
			case "1":
				handleAppointments(scanner, appointmentService);
				break;
			case "2":
				handleContacts(scanner, contactService);
				break;
			case "3":
				handleTasks(scanner, taskService);
				break;
			case "4":
				running = false;
				System.out.println("Exiting the application");
				break;
			default:
				System.out.println("Invalid choice.");
			}
		}
		scanner.close();
	}
	
	// Main menu for the program
	private static void printMainMenu() {
		System.out.println();
		System.out.println("=============== Main Menu ===============");
		System.out.println("1. Manage Appointments");
		System.out.println("2. Manage Contacts");
		System.out.println("3. Manage Tasks");
		System.out.println("4. Exit The Program");
		System.out.println("=========================================");
	}
	// Menu for handling appointments
	private static void handleAppointments(Scanner scanner, AppointmentService appointmentService) {
		// swap to true to return to main menu
		boolean back = false;
		
		while (!back) {
			System.out.println();
			System.out.println("1. Add Appointment");
			System.out.println("2. View Appointment by ID");
			System.out.println("3. Delete Appointment by ID");
			System.out.println("4. Back to Main Menu");
			System.out.println("Enter Choice:");
			
			String choice = scanner.nextLine().trim();
			
			switch (choice) {
			case "1":
				addAppointment(scanner, appointmentService);
				break;
			case "2":
				viewAppointment(scanner, appointmentService);
				break;
			case "3":
				deleteAppointment(scanner, appointmentService);
				break;
			case "4":
				back = true;
				break;
			default:
				System.out.println("Invalid choice");
				
			}
			
		}
	}
	private static void addAppointment(Scanner scanner, AppointmentService appointmentService) {
		try {
			System.out.print("Enter Appointment ID (MAX 10 Characters)");
			String id = scanner.nextLine().trim();
			
			System.out.println("Enter appointment date and time in this format: yyyy-MM-dd HH:mm");
			System.out.println("Example format: 2025-12-31 14:30");
			String dateStr = scanner.nextLine().trim();
			
			Date date;
			try {
				date = DATE_FORMAT.parse(dateStr);
			} catch (ParseException e) {
				System.out.println("Invalid date format. Appointment not created");
				return;
			}
			System.out.println("Enter description (MAX 50 characters)");
			String description = scanner.nextLine().trim();
			
			Appointment appointment = new Appointment(id, date, description);
			appointmentService.addAppointment(appointment);
			
			System.out.println("Created appointment successfully");
		} catch (IllegalArgumentException ex) {
			System.out.println("Error creating appointment: " + ex.getMessage());
		}
	}
	private static void viewAppointment(Scanner scanner, AppointmentService appointmentService) {
		System.out.print("Enter Appointment ID: ");
		String id = scanner.nextLine().trim();
		
		Appointment appointment = appointmentService.getAppointment(id);
		if (appointment == null) {
			System.out.println("Appointment with that ID not found");
		} else {
			System.out.println("Appointment Details: ");
			System.out.println("ID: " + appointment.getAppointmentID());
			System.out.println("Date: " + DATE_FORMAT.format(appointment.getAppointmentDate()));
			System.out.println("Description: " + appointment.getDescription());
		}
	}
	private static void deleteAppointment(Scanner scanner, AppointmentService appointmentService) {
		System.out.print("Enter Appointment ID to be deleted: ");
		String id = scanner.nextLine().trim();
		
		try {
			appointmentService.deleteAppointment(id);
			System.out.println("Appointment deleted successfully");
		} catch (IllegalArgumentException ex) {
			System.out.println("Error deleting appointment: " + ex.getMessage());
		}
	}
	 // ===== Contact Menu & Actions =====
    private static void handleContacts(Scanner scanner, ContactService contactService) {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("---------- CONTACTS ----------");
            System.out.println("1. Add Contact");
            System.out.println("2. Update Contact Phone");
            System.out.println("3. Update Contact Address");
            System.out.println("4. Back to Main Menu");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addContact(scanner, contactService);
                    break;
                case "2":
                    updateContactPhone(scanner, contactService);
                    break;
                case "3":
                    updateContactAddress(scanner, contactService);
                    break;
                case "4":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private static void addContact(Scanner scanner, ContactService contactService) {
        try {
            System.out.print("Enter Contact ID (max 10 chars): ");
            String id = scanner.nextLine().trim();

            System.out.print("Enter first name (max 10 chars): ");
            String firstName = scanner.nextLine().trim();

            System.out.print("Enter last name (max 10 chars): ");
            String lastName = scanner.nextLine().trim();

            System.out.print("Enter phone (10 digits, numbers only): ");
            String phone = scanner.nextLine().trim();

            System.out.print("Enter address (max 30 chars): ");
            String address = scanner.nextLine().trim();

            Contact contact = new Contact(id, firstName, lastName, phone, address);
            contactService.addContact(contact);

            System.out.println("Contact added successfully.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error adding contact: " + ex.getMessage());
        }
    }

    private static void updateContactPhone(Scanner scanner, ContactService contactService) {
        System.out.print("Enter Contact ID: ");
        String id = scanner.nextLine().trim();

        System.out.print("Enter new phone (10 digits): ");
        String phone = scanner.nextLine().trim();

        try {
            contactService.updatePhone(id, phone);
            System.out.println("Phone updated successfully.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error updating phone: " + ex.getMessage());
        }
    }

    private static void updateContactAddress(Scanner scanner, ContactService contactService) {
        System.out.print("Enter Contact ID: ");
        String id = scanner.nextLine().trim();

        System.out.print("Enter new address (max 30 chars): ");
        String address = scanner.nextLine().trim();

        try {
            contactService.updateAddress(id, address);
            System.out.println("Address updated successfully.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error updating address: " + ex.getMessage());
        }
    }

    // ===== Task Menu & Actions =====
    private static void handleTasks(Scanner scanner, TaskService taskService) {
        boolean back = false;

        while (!back) {
            System.out.println();
            System.out.println("------------ TASKS ------------");
            System.out.println("1. Add Task");
            System.out.println("2. View Task by ID");
            System.out.println("3. Update Task Name");
            System.out.println("4. Update Task Description");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    addTask(scanner, taskService);
                    break;
                case "2":
                    viewTask(scanner, taskService);
                    break;
                case "3":
                    updateTaskName(scanner, taskService);
                    break;
                case "4":
                    updateTaskDescription(scanner, taskService);
                    break;
                case "5":
                    back = true;
                    break;
                default:
                    System.out.println("Invalid selection. Please try again.");
            }
        }
    }

    private static void addTask(Scanner scanner, TaskService taskService) {
        System.out.print("Enter task name (max 20 chars): ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter task description (max 50 chars): ");
        String description = scanner.nextLine().trim();

        try {
            String taskId = taskService.addTask(name, description);
            System.out.println("Task added successfully. Generated Task ID: " + taskId);
        } catch (IllegalArgumentException ex) {
            System.out.println("Error adding task: " + ex.getMessage());
        }
    }

    private static void viewTask(Scanner scanner, TaskService taskService) {
        System.out.print("Enter Task ID: ");
        String id = scanner.nextLine().trim();

        Task task = taskService.getTask(id);
        if (task == null) {
            System.out.println("No task found with that ID.");
        } else {
            System.out.println("Task Details:");
            System.out.println("ID: " + task.getTaskId());
            System.out.println("Name: " + task.getName());
            System.out.println("Description: " + task.getDescription());
        }
    }

    private static void updateTaskName(Scanner scanner, TaskService taskService) {
        System.out.print("Enter Task ID: ");
        String id = scanner.nextLine().trim();

        System.out.print("Enter new name (max 20 chars): ");
        String name = scanner.nextLine().trim();

        try {
            taskService.updateTaskName(id, name);
            System.out.println("Task name updated successfully.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error updating task name: " + ex.getMessage());
        }
    }

    private static void updateTaskDescription(Scanner scanner, TaskService taskService) {
        System.out.print("Enter Task ID: ");
        String id = scanner.nextLine().trim();

        System.out.print("Enter new description (max 50 chars): ");
        String description = scanner.nextLine().trim();

        try {
            taskService.updateTaskDescription(id, description);
            System.out.println("Task description updated successfully.");
        } catch (IllegalArgumentException ex) {
            System.out.println("Error updating task description: " + ex.getMessage());
        }
    }
}
	