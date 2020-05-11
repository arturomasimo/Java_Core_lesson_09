package lession8_Exception;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * The Main class represents working with enums
 * @author ARTUR
 * @since JDK 13.0.2
 */


public class Main {
	// print menu 
	public static void printMenu() {
		System.out.println("Введіть 1  щоб перевірити чи є місяць в році");
		System.out.println("Введіть 2  щоб вивести всі місяці пори року");
		System.out.println("Введіть 3  щоб всі місяці з вказаною кількістю днів");
		System.out.println("Введіть 4  щоб всі місяці з меншою кількістю днів");
		System.out.println("Введіть 5  щоб всі місяці з більшою кількістю днів");
		System.out.println("Введіть 6  щоб вивести наступну пору року");
		System.out.println("Введіть 7  щоб вивести попередню пору року");
		System.out.println("Введіть 8  щоб вивести місяці з парною кількістю днів");
		System.out.println("Введіть 9  щоб вивести місяці з НЕпарною кількістю днів");
		System.out.println("Введіть 10 щоб вивести парна чи непарна кількість днів в місяці");
	}
	//check for the presence of the month
	public static boolean checkMonth(String s) {
		boolean f = false;
		for (Month month : Month.values()) {
			if (s.equalsIgnoreCase(month.name())) {
				f = true;
				break;
			}
		}
		return f;
	}
 // check for the presence of the season
	public static boolean checkSeason(String s) {
		boolean f = false;
		for (Season season : Season.values()) {
			if (s.equalsIgnoreCase(season.name())) {
				f = true;
				break;
			}
		}
		return f;
	}
// check the correctness of the month or season
	public static void checkErrors (String s1, String s2 ) throws WrongInputConsoleParametersException
	{
		String kirilica = "[а-яА-Я+]";
		Pattern pattern = Pattern.compile(kirilica);
		Matcher mather = pattern.matcher(s1);
		
		if(s1.length()<3 || s1.length()>9)
			throw new WrongInputConsoleParametersException("Назва "+s2+" введена невірно (кількість знаків)");
		if (!s1.matches("^\\D*$"))
			throw new WrongInputConsoleParametersException("Назва "+s2+" не може містити цифри");
		if (mather.find())
			throw new WrongInputConsoleParametersException("Назва "+s2+" не може містити кирилицю");
			
	}

	public static void main(String[] args) throws WrongInputConsoleParametersException  {
		Scanner scan = new Scanner(System.in);
		String st;
		
		while (true) {
			printMenu();
			st = scan.nextLine();
			switch (st) {
			case "1": {
				System.out.print("Введіть назву місяця : ");
				st = scan.nextLine();
				checkErrors(st, "місяця");
				if (checkMonth(st)) {
					System.out.println("Такий місяць існує");
				} else {
					System.out.println("Такого місяця немає");
				}
				break;
			}
			case "2": {
				System.out.print("Введіть пору року: ");
				st = scan.nextLine();
				checkErrors(st, "пори року");

				if (checkSeason(st)) {
					System.out.print("Пора року " + st.toUpperCase() + " має такі місяці: ");
					for (Month month : Month.values()) {
						if (month.getSeason().name().equalsIgnoreCase(st)) {
							System.out.print(month + " ");
						}
					}
					System.out.println();
				} else {
					System.out.println("Такого місяця немає");
				}
				break;
			}
			case "3": {
				System.out.print("Введіть назву місяця: ");
				st = scan.nextLine();
				checkErrors(st, "місяця");

				if (checkMonth(st)) {
					Month month = Month.valueOf(st.toUpperCase());
					System.out.print("Кількість днів у місяця " + st.toUpperCase() + " має " + month.getDays()
							+ " днів і мають такі місяці: ");
					for (Month m2 : Month.values()) {
						if (m2.getDays() == month.getDays()) {
							System.out.print(m2 + " ");
						}
					}
					System.out.println();
				} else {
					System.out.println("Такого місяця немає");
				}
				break;
			}
			case "4": {
				System.out.print("Введіть назву місяця : ");
				st = scan.nextLine();
				checkErrors(st, "місяця");
				if (checkMonth(st)) {
					Month month = Month.valueOf(st.toUpperCase());
					System.out.print("Кількість днів у місяця " + st.toUpperCase() + " має " + month.getDays()
							+ " днів і МЕНШЕ мають такі місяці: ");
					for (Month m2 : Month.values()) {
						if (m2.getDays() < month.getDays()) {
							System.out.print(m2 + "(" + m2.getDays() + ") ");
						}
					}
					System.out.println();
				} else {
					System.out.println("Такого місяця немає");
				}
				break;
			}
			case "5": {
				System.out.print("Введіть назву місяця : ");
				st = scan.nextLine();
				checkErrors(st, "місяця");
				if (checkMonth(st)) {
					Month month = Month.valueOf(st.toUpperCase());
					System.out.print("Кількість днів у місяця " + st.toUpperCase() + " має " + month.getDays()
							+ " днів і БЫЛЬШЕ мають такі місяці: ");
					for (Month m2 : Month.values()) {
						if (m2.getDays() > month.getDays()) {
							System.out.print(m2 + "(" + m2.getDays() + ") ");
						}
					}
					System.out.println();
				} else {
					System.out.println("Такого місяця немає");
				}
				break;
			}
			case "6": {
				System.out.print("Введіть пору року: ");
				st = scan.nextLine();
				checkErrors(st, "пори року");
				if (checkSeason(st)) {
					System.out.print("Пора року " + st.toUpperCase() + " має наступну після себе ");
					if (Season.valueOf(st.toUpperCase()).ordinal() == 3)
						System.out.print(Season.values()[0]);
					else
						System.out.print(Season.values()[Season.valueOf(st.toUpperCase()).ordinal() + 1]);
					System.out.println();
				} else {
					System.out.println("Такої пори року немає");
				}
				break;
			}
			case "7": {
				System.out.print("Введіть пору року: ");
				st = scan.nextLine();
				checkErrors(st, "пори року");

				if (checkSeason(st)) {
					System.out.print("Пора року " + st.toUpperCase() + " має попередню до себе ");
					if (Season.valueOf(st.toUpperCase()).ordinal() == 0)
						System.out.print(Season.values()[3]);
					else
						System.out.print(Season.values()[Season.valueOf(st.toUpperCase()).ordinal() - 1]);
					System.out.println();
				} else {
					System.out.println("Такої пори року немає");
				}
				break;
			}
			case "8": {
				System.out.print("Місяці з парною кількістю днів: ");
				for (Month m2 : Month.values()) {
					if (m2.getDays() % 2 == 0) {
						System.out.print(m2 + " " + m2.getDays() + ", ");
					}
				}
				System.out.println();
				break;
			}

			case "9": {
				System.out.print("Місяці з НЕпарною кількістю днів: ");
				for (Month m2 : Month.values()) {
					if (m2.getDays() % 2 == 1) {
						System.out.print(m2 + " " + m2.getDays() + ", ");
					}
				}
				System.out.println();
				break;
			}
			case "10": {
				System.out.print("Введіть назву місяця: ");
				st = scan.nextLine();
				checkErrors(st, "місяця");

				if (checkMonth(st)) {
					Month month = Month.valueOf(st.toUpperCase());
					if (month.getDays() % 2 == 0) {
						System.out.print(month + " має парну кількість днів (" + month.getDays() + ")");
					} else {
						System.out.print(month + " має НЕпарну кількість днів (" + month.getDays() + ")");
					}
					System.out.println();
				} else {
					System.out.println("Такого місяця немає");
				}
				break;
			}
			default:
				throw new WrongInputConsoleParametersException("Неправильне значення: " + st);
			}
		}
	}

}
