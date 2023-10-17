package com.Athira.kelexam.generator.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.TableRowAlign;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;

import com.Athira.kelexam.generator.controller.QuestionSelector.QuestionType;
import com.Athira.kelexam.model.EssayQuery;
import com.Athira.kelexam.model.FIBQuery;
import com.Athira.kelexam.model.MCQQuery;
import com.Athira.kelexam.model.MTFQuery;
import com.Athira.kelexam.model.TFQuery;
import com.Athira.kelexam.questions.model.Essaymodel;
import com.Athira.kelexam.questions.model.FIBmodel;
import com.Athira.kelexam.questions.model.MCQmodel;
import com.Athira.kelexam.questions.model.MTFmodel;
import com.Athira.kelexam.questions.model.TFmodel;

public class CreateQuestionPaper {
	private XWPFDocument document=null;
	private File wordFile=null;
	public XWPFDocument getDocument() {
		return document;
	}
	public void setDocument(XWPFDocument document) {
		this.document = document;
	}
	public File getWordFile() {
		return wordFile;
	}
	public void setWordFile(File wordFile) {
		this.wordFile = wordFile;
	}
	private Random random=new Random();
	private void createWordFile() throws IOException {
	Path path=	Files.copy(new File("src/main/resources/QuestionPaperModeldoc.docx").toPath(),
				File.createTempFile("question", ".docx").toPath(), StandardCopyOption.REPLACE_EXISTING);
	wordFile=path.toFile();
	}
	private void createDocument() throws FileNotFoundException, IOException {
		createWordFile();
		document=new XWPFDocument(new FileInputStream(wordFile));
	}
	private void writeHeader(String questionPaperNo) {
		XWPFHeaderFooterPolicy policy = document.getHeaderFooterPolicy();
		policy.getDefaultHeader().getParagraph(null);
		 CTP ctP1 = CTP.Factory.newInstance();
		 CTR ctR1 = ctP1.addNewR();
		 CTText t = ctR1.addNewT();
		 t.setStringValue("Paragraph in header");
		 XWPFParagraph p1 = new XWPFParagraph(ctP1, document);
		 XWPFParagraph[] pars = new XWPFParagraph[1];
		 pars[0] = p1;

		 policy.createHeader(policy.FIRST, pars);
		
	}
	
	private void writeMcqQuestions(int no,String paper,int count) throws SQLException {
		XWPFParagraph para1=document.createParagraph();
		
		XWPFRun run1= para1.createRun();
		run1.setText(no+". Each question below gives MULTIPLE CHOICES of answers."
				+ " Choose the most appropriate one and enter the answer sheet provided with "
				+ "the question paper;                               (1*10)");
		run1.setBold(true);
		run1.setFontSize(12);
		XWPFTable table=null;
		XWPFTableRow row=null;
		XWPFTableCell cell=null;
		
		int i=1;
		for (MCQmodel mcq : new MCQQuery().retriveQuestion(paper, count)) {
			para1=document.createParagraph();
			para1.createRun().setText(no+"."+i+"  "+mcq.getQuestion());
			String option[]=new String[] {mcq.getAnswer(),mcq.getOption1(),mcq.getOption2(),
					mcq.getOption3()};
			List<Integer> numbers = new ArrayList<Integer>(10); 
			for (int j = 0; j < 4; j++) { 
			  numbers.add(j); 
			Collections.shuffle(numbers); 
			}
			table=document.createTable();
			table.setWidth("80%");
			table.setTableAlignment(TableRowAlign.CENTER);
			row=table.getRow(0);
			cell= row.getCell(0);
			cell.setWidth("50%");
			cell.setText("a) "+option[numbers.get(0)]);
			cell= row.addNewTableCell();
			cell.setWidth("50%");
			cell.setText("b) "+option[numbers.get(1)]);
			row=table.createRow();
			cell= row.getCell(0);
			cell.setWidth("50%");
			cell.setText("c) "+option[numbers.get(2)]);
			cell=row.getCell(1);
			cell.setWidth("50%");
			cell.setText("d) "+option[numbers.get(3)]);
			table.getCTTbl().getTblPr().unsetTblBorders();
			i++;
		}
	}
	private void writeTfQuestions(int no,String paper,int count) throws SQLException {
		XWPFParagraph para1=document.createParagraph();
		XWPFRun run1= para1.createRun();
		run1.setText(no+". Each statement below is TRUE or FALSE. Choose the most appropriate one and "
				+ "record in the answer sheet provided with the question paper:     "
				+ "                                               (10*1=10)");
		run1.setBold(true);
		run1.setFontSize(12);
		int i=1;
		for (TFmodel tf : new TFQuery().retriveQuestion(paper, count)) {
			para1=document.createParagraph();
			para1.createRun().setText(no+"."+i+"  "+tf.getQuestion());
			i++;
		}
	}
	/**
	 * @param no
	 * @param paper
	 * @param count
	 * @throws SQLException
	 */
	private void writeMtfQuestions(int no,String paper,int count) throws SQLException {
		XWPFParagraph para1=document.createParagraph();
		XWPFRun run1= para1.createRun();
		run1.setText(no+". MATCH word and phrases in column X with the nearest in the meaning to those "
				+ "in the column Y. Choose the most appropriate one and record in the answer sheet"
				+ " provided with the question paper:                        "
				+ "                                                                  "
				+ "                       (10*1=10)");
		run1.setBold(true);
		run1.setFontSize(12);
		XWPFTable table=document.createTable(count, 2);
		table.setTableAlignment(TableRowAlign.CENTER);
		table.setWidth("85%");
		
		List<Integer> numbers = new ArrayList<Integer>(10); 
		for (int j = 0; j <count; j++) { 
		  numbers.add(j); 
		Collections.shuffle(numbers); 
		}
		List<MTFmodel>list=new MTFQuery().retriveQuestion(paper, count);
		String answers[]=new String[count];
		int j=0;
		for (MTFmodel mtf :list ) {
		
			answers[j]=mtf.getAnswer();
		j++;
		}
		int c=65;
		int i=0;
		for (MTFmodel mtf :list ) {
		
				table.getRow(i).getCell(0).setText(no+"."+(i+1)+" " +mtf.getQuestion());
				table.getRow(i).getCell(1).setText((char)c+") "+answers[numbers.get(i)]);
			i++;
			c++;
		}
	}
	private void writefibQuestions(int no,String paper,int count) throws SQLException {
		XWPFParagraph para1=document.createParagraph();
		XWPFRun run1= para1.createRun();
		run1.setText(no+". Each sentence below has a BLANK space to fit one of the words or phrases in the list below"
				+ " Choose the most appropriate one and record in the answer sheet provided with the question paper. "
				+ "                                                                  (10*1=10)");
		run1.setBold(true);
		run1.setFontSize(12);
		XWPFTable table=document.createTable(3,4);
		table.setWidth("100%");
		List<FIBmodel> list=new FIBQuery().retriveQuestion(paper, count);
		List<Integer> numbers = new ArrayList<Integer>(10); 
		for (int j = 0; j < count; j++) { 
		  numbers.add(j); 
		Collections.shuffle(numbers); 
		}
		int j=0;
		String answers[]=new String[count];
		for (FIBmodel fib :list ) {
			answers[j]=fib.getAnswer();
			j++;
		}
		int k=0;
		int m=0;
		int c=65;
		while (k<3) {
			table.getRow(k).getCell(0).setText((char)c+") "+answers[numbers.get(m)]);
			m++;c++;
			table.getRow(k).getCell(1).setText((char)c+") "+answers[numbers.get(m)]);
			m++;c++;
			if(k!=2) {
			table.getRow(k).getCell(2).setText((char)c+") "+answers[numbers.get(m)]);
			m++;c++;
			table.getRow(k).getCell(3).setText((char)c+") "+answers[numbers.get(m)]);
			m++;c++;
			}
			k++;
		}
		int i=1;
		for (FIBmodel fib :list ) {
			para1=document.createParagraph();
			para1.createRun().setText(no+"."+i+" "+fib.getQuestion());
			i++;
		}
	}
	private void writeEssayQuestions(int no,String paper,int count,QuestionType type,int attend) throws SQLException {
		XWPFParagraph para1=document.createParagraph();
		XWPFRun run1=para1.createRun();
		para1.setAlignment(ParagraphAlignment.CENTER);
		run1.setBold(true);
		run1.setFontSize(12);
		run1.setText("PART TWO");
		run1.setUnderline(UnderlinePatterns.DASH);
		switch (type) {
		case ESSAY:
			para1=document.createParagraph();
			run1= para1.createRun();
			run1.setBold(true);
			run1.setFontSize(12);
			run1.setText("Answer "+attend+" questions; each carries 15 mark                                 "
					+ "                        [15*"+attend+"="+(attend*15)+" MARK]");
			int i=no;
			for (Essaymodel essay : new EssayQuery().retriveQuestion(paper, count)) {
				para1=document.createParagraph();
				run1= para1.createRun();
				run1.setText(i+". "+essay.getQuestion());
				i++;
			}
			break;
		case MARK2:
			para1=document.createParagraph();
			run1= para1.createRun();
			run1.setBold(true);
			run1.setFontSize(12);
			run1.setText("Answer "+attend+" questions; each carries 2 mark                                 "
					+ "                        [2*"+attend+"="+(attend*2)+" MARK]");
			break;
		case MARK4:
			para1=document.createParagraph();
			run1= para1.createRun();
			run1.setBold(true);
			run1.setFontSize(12);
			run1.setText("Answer "+attend+" questions; each carries 4 mark                                 "
					+ "                        [4*"+attend+"="+(attend*4)+" MARK]");
			break;	
		case MARK5:
			para1=document.createParagraph();
			run1= para1.createRun();
			run1.setBold(true);
			run1.setFontSize(12);
			run1.setText("Answer "+attend+" questions; each carries 5 mark                                 "
					+ "                        [5*"+attend+"="+(attend*5)+" MARK]");
			break;
		case MARK10:
			para1=document.createParagraph();
			run1= para1.createRun();
			run1.setBold(true);
			run1.setFontSize(12);
			run1.setText("Answer "+attend+" questions; each carries 10 mark                                 "
					+ "                        [10*"+attend+"="+(attend*10)+" MARK]");
			break;
		default:
			break;
		}
	}
	public void writePaper(List<QuestionType> types,String paper,List<Integer> count,List<Integer> mark,String date) throws FileNotFoundException, IOException, SQLException {
		createDocument();
		//writeHeader(null);
		
		int i=1;
		for (QuestionType questionType : types) {
			switch (questionType) {
			case MCQ:
				writeMcqQuestions(i,paper+1,count.get(0));
				break;
			case TF:
				writeTfQuestions(i, paper+1,count.get(1));
				break;
			case MTF:
				writeMtfQuestions(i, paper+1, count.get(2));
				break;
			case FIB:
				writefibQuestions(i, paper+1, count.get(3));
				break;
			case ESSAY:
				writeEssayQuestions(i, paper+1, count.get(4), QuestionType.ESSAY,mark.get(4)/15);
				break;
			case MARK2:
				writeEssayQuestions(i, paper+1, count.get(5), QuestionType.MARK2,mark.get(5)/2);
				break;
			case MARK4:
				writeEssayQuestions(i, paper+1, count.get(6), QuestionType.MARK4,mark.get(6)/4);
				break;
			case MARK5:
				writeEssayQuestions(i, paper+1, count.get(7), QuestionType.MARK5,mark.get(7)/5);
				break;
			case MARK10:
				writeEssayQuestions(i, paper+1, count.get(8), QuestionType.MARK10,mark.get(8)/10);
				break;

			default:
				break;
			}
			i++;
		}
		
		FileOutputStream out=new FileOutputStream(wordFile);
		document.write(out);
		document.close();
	}

}
