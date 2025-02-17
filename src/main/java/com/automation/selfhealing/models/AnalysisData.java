package com.automation.selfhealing.models;

import org.opencv.core.Mat;

public record AnalysisData(String dom, Mat visualData) {

    @Override
    public String toString() {
        return "AnalysisData{" +
                "dom='" + dom + '\'' +
                ", visualData=" + visualData +
                '}';
    }
}
