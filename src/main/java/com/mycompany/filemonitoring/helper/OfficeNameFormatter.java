package com.mycompany.filemonitoring.helper;

public class OfficeNameFormatter {
    public static String formatOfficeName(String office) {
        if (office == null) return "";

        switch (office.toLowerCase()) {
            case "president":
                return "President";
            case "executive_vp":
                return "Executive Vice President";
            case "vp_of_academic_affairs":
                return "Vice President of Academic Affairs";
            case "vp_for_administration_and_finance":
                return "Vice President for Administration and Finance";
            case "college_and_board_secretary":
                return "College and Board Secretary";
            default:
                return "Others";
        }
    }
}
