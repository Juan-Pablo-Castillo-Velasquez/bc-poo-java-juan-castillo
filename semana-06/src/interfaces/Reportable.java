package interfaces;


public interface Reportable {
    String generateDetailedReport();
    void exportReport(String format);
    boolean needsApproval();
}