package com.softsquare.application.service;

import java.util.ArrayList;

import com.softsquare.application.entity.Project;
import com.softsquare.application.entity.Working;

public interface ImportMaterialService {
	public ArrayList<Working> findProjectOfEngineer();
}
