package models.entities.reports;

import models.entities.loan.Loan;
import models.entities.persons.Member;
import models.services.LoanService;

import java.time.format.DateTimeFormatter;
import java.util.Set;

public class ReportLoansMember implements Report {

    // VERIFICAR SE TEM LOANS SE TIVER MOSTRAR TODOS OS LOANS

    private Member member;
    private Set<Loan> loans;
    private static final DateTimeFormatter fmtH = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private static final LoanService ls = new LoanService();

    public ReportLoansMember(Member member) {
        this.member = member;
        this.loans = member.getLoans();
    }

    @Override
    public String generateReport() {
        if (loans == null) {
            return "The memeber, " + member.getName() + " has no loans!" ;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------\n");
        sb.append(" Report Member Loan \n");
        sb.append("---------------------------\n");

        loans.forEach(l -> {
            System.out.println("teadasda");
                ls.verifyLoan(l);

                sb.append("ISBN: ").append(l.getBook().getIsbn()).append(" | State: ")
                    .append(l.getStateLoan()).append("\n").append("Borrowed Book: ").append(l.getBook().getTitle())
                    .append(" | Member: ").append(l.getMember().getName()).append("\n")
                    .append("Expected return date: ").append(fmtH.format(l.getLoanDate().plusDays(5)))
                    .append(" | Return date: ").append(l.getReturnDate() != null ? fmtH.format(l.getReturnDate()) : "---").append("\n").append("Fine: ")
                    .append(String.format("$ %.2f", l.getFine())).append(" | Loan date: ").append(l.getLoanDate().format(fmtH)).append("\n")
                    .append("---------------------------\n");
                }

        );
        return sb.toString();
    }
}
