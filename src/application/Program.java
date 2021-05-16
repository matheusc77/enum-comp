package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf1 = new SimpleDateFormat("MM/yyyy");
		
		System.out.print("Entre o nome do departamento: ");
		String departmentName = sc.nextLine();
		System.out.print("Entre dados do funcionário: ");
		String workerName = sc.nextLine();
		System.out.print("Entre nível do funcionário: ");
		String workerLevel = sc.nextLine();
		System.out.print("Entre salário do funcionário: ");
		double baseSalary = sc.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		System.out.print("Quantos contratos o trabalhador tem? ");
		int n = sc.nextInt();
		
		for(int i=1; i<=n; i++) {
			System.out.println("Entre dados do contrato #" + i + ": " );
			System.out.print("Data (DD/MM/AAAA): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Duração (horas): ");
			int hours = sc.nextInt();
			HourContract contract = new HourContract(contractDate, valuePerHour, hours);
			worker.addContract(contract);
		}
		
		System.out.print("Entre o mês e ano para calcular renda: ");
		String dateIn = sc.next();
		int month = Integer.parseInt(dateIn.substring(0, 2));
		int year = Integer.parseInt(dateIn.substring(3));
		System.out.println("Nome: " + worker.getName());
		System.out.println("Departamento: " + worker.getDepartment().getName());
		System.out.println("Salário do mês " + dateIn + ": " + String.format("%.2f", worker.income(year, month)));
		
		sc.close();
		
	}

}
