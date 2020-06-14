package com.brainmentors.testenginedemo.Services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.brainmentors.testenginedemo.heplers.TestHelper;
import com.brainmentors.testenginedemo.models.test.Answer;
import com.brainmentors.testenginedemo.models.test.Question;
import com.brainmentors.testenginedemo.models.test.QuestionResponse;
import com.brainmentors.testenginedemo.models.test.QuestionTestMap;
import com.brainmentors.testenginedemo.models.test.RegCodesResponse;
import com.brainmentors.testenginedemo.models.test.ScoreResponse;
import com.brainmentors.testenginedemo.models.test.Test;
import com.brainmentors.testenginedemo.models.test.TestResponse;



@Service
public class TestService {
	@Autowired
	private TestHelper helper;

	public TestResponse addTest(Test test) {
		TestResponse response = helper.addTest(test);
		return response;
	}
	
	public QuestionResponse addQuestion(Question question) {
		return helper.addQuestion(question);
	}
	
	public QuestionResponse testQuestionMap(QuestionTestMap questions) {
		return helper.testQuestionMap(questions);
	}
	
	public QuestionResponse getAllQuestionsByTest(int testid) {
		return helper.getAllQuestionsByTest(testid);
	}
	
	public QuestionResponse getAllQuestionsByUser(int userid) {
		return helper.getAllQuestionsByUser(userid);
	}
	
	public Question getQuestion(int questionid) {
		return helper.getQuestion(questionid);
	}
	
	public TestResponse getAllTest(int uid) {
		return helper.getAllTest(uid);
	}
	
	public RegCodesResponse getRegCodes(int gid, int num) {
		return helper.getRegCodes(gid, num);
	}
	
	public ScoreResponse getScores(int testid) {
		return helper.getScores(testid);
	}
	
//	public void upload(MultipartFile file) throws Exception {
//		System.out.println("Inside Service");
//		Path tempDir = Files.createTempDirectory("");
//
//		File tempFile = tempDir.resolve(file.getOriginalFilename()).toFile();
//		
//		file.transferTo(tempFile);
//
//		Workbook workbook = WorkbookFactory.create(tempFile);
//
//		Sheet sheet = workbook.getSheetAt(0);
//		Iterator<Row> rows = sheet.rowIterator();
//		boolean isFirstRow = true;
//		ArrayList<Question> questions = new ArrayList<Question>();
//		ArrayList<Answer> answers = new ArrayList<Answer>();
//		while(rows.hasNext()) {
//			Question question = new Question();
//			Row currentRow = rows.next();
//			if(isFirstRow) {
//				isFirstRow = false;
//				continue;
//			}
//			int count = 1;
////			int a = 97;
////			ArrayList<Answer> answers = new ArrayList<Answer>();
//			Iterator<Cell> cells = currentRow.cellIterator();
////			Cell lastcell = currentRow.getCell(currentRow.getLastCellNum()-1);
////			String rightans = lastcell.getStringCellValue();
////			System.out.println(rightans.length());
////			char rightch = rightans.charAt(0);
////			System.out.println("RightAns is "+rightans);
//			while(cells.hasNext()) {
//				String cellValue = "";
//				Cell currentCell = cells.next();
//					if(currentCell.getCellType() == CellType.STRING) {
//						cellValue = currentCell.getStringCellValue();
//					}
//					else
//						if(currentCell.getCellType() == CellType.NUMERIC) {
//							cellValue = String.valueOf(currentCell.getNumericCellValue());
//						}
//					
//					if(count == 1) {
//						question.setQid((int) Double.parseDouble(cellValue));;
//						
//					}
//					else
//						if(count == 2) {
//							question.setName(cellValue);
//							
//						}
//						else
//							if(count == 3) {
//								question.setScore(cellValue);
//								
//							}
//					count++;
//				
//			}  // cell loop end
////			question.setAnswers(answers);
//			System.out.println("Question "+question);
////			uploadAnswer(question, workbook);
//			questions.add(question);
//		}  // row loop end
//		answers = uploadAnswer(workbook);
//		System.out.println("Questions "+questions);
//		for (Question question : questions) {
//			int qid = question.getQid();
//			ArrayList<Answer> list = new ArrayList<Answer>();
//			for (Answer answer : answers) {
//				if (answer.getQid() == qid) {
//					list.add(answer);
//				}
//			}
//			question.setAnswers(list);
//		}
//		System.out.println("Final Question "+questions);
//	}
//	
//	public ArrayList<Answer> uploadAnswer(Workbook workbook) {
//		Sheet sheet1 = workbook.getSheetAt(1);
//		Iterator<Row> rows = sheet1.rowIterator();
//		boolean isFirstRow = true;
//		ArrayList<Answer> answers = new ArrayList<Answer>();
//		while (rows.hasNext()) {
//			Answer answer = new Answer();
//			Row currentRow = rows.next();
//			if(isFirstRow) {
//				isFirstRow = false;
//				continue;
//			}
//			int count = 1;
//			Iterator<Cell> cells = currentRow.cellIterator();
//			while(cells.hasNext()) {
//				String cellValue = "";
//				Cell currentCell = cells.next();
//					if(currentCell.getCellType() == CellType.STRING) {
//						cellValue = currentCell.getStringCellValue();
//					}
//					else
//						if(currentCell.getCellType() == CellType.NUMERIC) {
//							cellValue = String.valueOf(currentCell.getNumericCellValue());
//						}
//					
//					if(count == 1) {
//						answer.setQid((int) Double.parseDouble(cellValue));;
//						
//					}
//					else
//						if(count == 2) {
//							answer.setName(cellValue);
//							
//						}
//						else
//							if(count == 3) {
//								answer.setDescr(cellValue);
//								
//							}
//							else
//								if(count == 4) {
//									answer.setRightAns(cellValue);
//									
//								}
//					count++;
//				
//			}  // cell loop end
//			System.out.println("Answer "+answer);
//			answers.add(answer);
//		}  //row loop end
//		System.out.println("Answers "+answers);
//		return answers;
//	}

}
