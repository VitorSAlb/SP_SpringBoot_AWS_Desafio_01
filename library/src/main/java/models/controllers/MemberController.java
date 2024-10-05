package models.controllers;

import models.entities.persons.Author;
import models.entities.persons.Member;
import models.services.MemberService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static application.UI.enterToContinue;

public class MemberController {

    private static final Scanner sc = new Scanner(System.in);
    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private static final MemberService ms = new MemberService();

    public void createMember() {
        System.out.println("Let's go register a new member: ");
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter telephone: ");
        String tel = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.println("Enter association date (dd/mm/yyyy): ");
        String date = sc.nextLine();

        Member m = new Member(name, email, tel, address, LocalDate.parse(date, fmt));
        ms.newMember(m);
    }

    public void listMembers() {
        List<Member> members = ms.listMembers().stream().sorted().toList();

        if (members.isEmpty()) {
            System.out.println("No member found.");
        } else {
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println("List of Members in alphabetical order");
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            int count = 1;
            for (Member m: members) {
                System.out.println(count + "º - " + m);
                count++;
            }
        }
    }

    public void searchMember() {
        Member member;

        System.out.print("Enter email of the member: ");
        String email = sc.nextLine();
        member = ms.searchMember(email);
        if (member != null ) {
            System.out.println("------------------------------------------------------------------------------------------------------------------");
            System.out.println(member);
            System.out.println("------------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("This member is not registered in our library");
            enterToContinue();
        }
    }

    public Member returnSearchMember() {
        Member member;

        System.out.print("Enter email of the member: ");
        String email = sc.nextLine();
        member = ms.searchMember(email);
        if (member != null ) {
            return member;
        } else {
            System.out.println("This member is not registered in our library");
            enterToContinue();
        }

        return null;
    }

    public void editMember(Member member) {
        System.out.println("Current Member data");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println(member);
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println("Note: If you don't want to change anything, just press enter.");
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        if (name.length() > 1) {
            member.setName(name);
        }

        System.out.print("Enter email: ");
        String email = sc.nextLine();

        if (email.length() > 1) {
            member.setEmail(email);
        }

        System.out.print("Enter address: ");
        String add = sc.nextLine();

        if (add.length() > 1) {
            member.setAddress(add);
        }

        System.out.print("Enter telephone: ");
        String tel = sc.nextLine();

        if (tel.length() > 1) {
            member.setTelephone(tel);
        }

        ms.updateMember(member);
        System.out.println("Updated member");
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        System.out.println(member);
        System.out.println("------------------------------------------------------------------------------------------------------------------");
    }

}
