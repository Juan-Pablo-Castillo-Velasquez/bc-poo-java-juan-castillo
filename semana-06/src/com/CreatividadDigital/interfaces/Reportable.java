package com.CreatividadDigital.interfaces;


public interface Reportable {
    String generateDetailedReport();
    void exportReport(String format);
    boolean needsApproval();
}