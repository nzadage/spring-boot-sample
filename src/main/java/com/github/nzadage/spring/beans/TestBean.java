package com.github.nzadage.spring.beans;

import org.springframework.stereotype.Component;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

@Component
public class TestBean {
	public static void main(String[] args) {
		try {
			PdfReader pdfReader = new PdfReader("test.pdf");
			
			System.out.println(pdfReader.getNumberOfPages());
			String text = PdfTextExtractor.getTextFromPage(pdfReader, 1);
			System.out.println(text);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}