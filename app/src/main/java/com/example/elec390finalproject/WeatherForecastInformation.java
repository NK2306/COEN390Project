package com.example.elec390finalproject;

import java.util.ArrayList;

public class WeatherForecastInformation {
    private double Maxtemp;
    private double Mintemp;
    private double AvgTemp;
    private boolean IsGonnaRain;
    private boolean IsGonnaSnow;
    private String[] ColdWeatherItems = {"Winter Coat", "Warm Boots", "Gloves and Scarf"};
    private String[] ChillingWeatherItems = {"Jacket", "Shoes", "Long Pants"};
    private String[] RainItems = {"Umbrella"};
    private String[] SnowItems = {"Winter Boots"};

    public double getMaxtemp() {
        return Maxtemp;
    }

    public void setMaxtemp(double maxtemp) {
        Maxtemp = maxtemp;
    }

    public double getMintemp() {
        return Mintemp;
    }

    public void setMintemp(double mintemp) {
        Mintemp = mintemp;
    }

    public double getAvgTemp() {
        return ((Maxtemp + Mintemp)/2);
    }

    public boolean isGonnaRain() {
        return IsGonnaRain;
    }

    public void setGonnaRain(int RainProbability) {
        if (RainProbability > 0)
            IsGonnaRain = true;
        else
            IsGonnaRain = false;
    }

    public boolean isGonnaSnow() {
        return IsGonnaSnow;
    }

    @Override
    public String toString() {
        return "WeatherForecastInformation{" +
                "Maxtemp=" + Maxtemp +
                ", Mintemp=" + Mintemp +
                ", AvgTemp=" + getAvgTemp() +
                ", IsGonnaRain=" + IsGonnaRain +
                ", IsGonnaSnow=" + IsGonnaSnow +
                '}';
    }

    public void setGonnaSnow(int SnowProbability) {
        if (SnowProbability > 0)
            IsGonnaSnow = true;
        else
            IsGonnaSnow = false;
    }

    public String makeClothingSuggestion()
    {
        double AvgTemp = (Maxtemp + Mintemp)/2;
        String suggestion = "For today weather, you should wear: \n";

        if (AvgTemp < 32)
        {
            for (int Index = 0; Index < ColdWeatherItems.length; Index++)
            {
                suggestion += "\t +" + ColdWeatherItems[Index] + "\n";
            }
        }
        else if (AvgTemp < 70)
    {
        for (int Index = 0; Index < ChillingWeatherItems.length; Index++)
        {
            suggestion += "\t +" + ChillingWeatherItems[Index] + "\n";
        }
    }
    else if (AvgTemp < 90)
    {
        suggestion = "It's a warm day! ";
    }
    else
    {
        suggestion = "It's a hot day today, stay hydrated. ";
    }

    if (isGonnaRain())
    {
        suggestion += "It will rain today, don't forget to bring your umbrella. ";
    }

    if (isGonnaSnow())
    {
        suggestion += "It will snow today, don't forget to bring your Snow Boots. ";
    }

    return suggestion;
    }
}
