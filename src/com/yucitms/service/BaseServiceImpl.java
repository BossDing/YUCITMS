package com.yucitms.service;

import javax.annotation.Resource;

import com.yucitms.dao.attendance.AttendanceListDao;
import com.yucitms.dao.attendance.AttendanceMainDao;
import com.yucitms.dao.attendance.ComputerRoomDao;
import com.yucitms.dao.bbs.PostDAO;
import com.yucitms.dao.bbs.ResponseDAO;
import com.yucitms.dao.bbs.TypeDAO;
import com.yucitms.dao.exam.ClassifyDAO;
import com.yucitms.dao.exam.DifficultyDAO;
import com.yucitms.dao.exam.ExamPaperDAO;
import com.yucitms.dao.exam.GroupingDAO;
import com.yucitms.dao.exam.PaperClassifyDAO;
import com.yucitms.dao.exam.PaperGroupingDAO;
import com.yucitms.dao.exam.PaperSourceDAO;
import com.yucitms.dao.exam.QuestionsDAO;
import com.yucitms.dao.exam.QuestionsGroupingDAO;
import com.yucitms.dao.exam.Questions_DanXuanDAO;
import com.yucitms.dao.exam.Questions_DuoXuanDAO;
import com.yucitms.dao.exam.Questions_JianDaDAO;
import com.yucitms.dao.exam.Questions_PanDuanDAO;
import com.yucitms.dao.exam.Questions_TianKongDAO;
import com.yucitms.dao.exam.SourceDAO;
import com.yucitms.dao.netLesson.DifficultyGuidanceDAO;
import com.yucitms.dao.netLesson.ExcellentCourseDAO;
import com.yucitms.dao.netLesson.ExcellentTeacherDAO;
import com.yucitms.dao.netLesson.ExcellentVideoDAO;
import com.yucitms.dao.netLesson.ExpandApplicationDAO;
import com.yucitms.dao.netLesson.ExperimentCaseDAO;
import com.yucitms.dao.netLesson.ImgCarouselDAO;
import com.yucitms.dao.netLesson.LessionBookDAO;
import com.yucitms.dao.netLesson.ReferenceDataDAO;
import com.yucitms.dao.practicalTraining.PracticalTrainingTemplateDao;
import com.yucitms.dao.school.ClassRoomDAO;
import com.yucitms.dao.school.CourseDAO;
import com.yucitms.dao.school.DepartmentDAO;
import com.yucitms.dao.school.MajorDao;
import com.yucitms.dao.school.StudentDao;
import com.yucitms.dao.school.TeacherDao;
import com.yucitms.service.exam.PaperClassifyService;

public class BaseServiceImpl implements BaseService{
	/**
	 * 精品课程
	 */
	@Resource
	private DifficultyGuidanceDAO difficultyGuidanceDAO;
	@Resource
	private ExcellentTeacherDAO excellentTeacherDAO;
	@Resource
	private ExpandApplicationDAO expandApplicationDAO;
	@Resource
	private ExcellentCourseDAO excellentCourseDAO;
	@Resource
	private ExperimentCaseDAO experimentCaseDAO;
	@Resource
	private LessionBookDAO lessionBookDAO;
	@Resource
	private ReferenceDataDAO referenceDataDAO;
	@Resource
	private ExcellentVideoDAO excellentVideoDAO;
	@Resource 
	private ImgCarouselDAO imgCarouselDAO;
	/**
	 * 帖子论坛
	 */
	
	@Resource
	private PostDAO postDAO;
	@Resource
	private ResponseDAO responseDAO;
	@Resource
	private TypeDAO typeDAO;
	/**
	 * 学校基本信息
	 */
	@Resource
	private ClassRoomDAO classRoomDAO;
	@Resource
	private CourseDAO courseDAO;
	@Resource
	private DepartmentDAO departmentDAO;
	@Resource
	private MajorDao majorDao;
	@Resource
	private StudentDao studentDao;
	@Resource
	private TeacherDao teacherDao;
	@Resource
	private ComputerRoomDao computerRoomDao;
	/**

	 * 考试基本信息
	 */
	@Resource
	private ClassifyDAO classifyDAO;
	@Resource
	private DifficultyDAO difficultyDAO;
	@Resource
	private GroupingDAO groupingDAO;
	@Resource
	private QuestionsDAO questionsDAO;
	@Resource
	private SourceDAO sourceDAO;
	@Resource
	private Questions_JianDaDAO jianDaDAO;
	@Resource
	private Questions_PanDuanDAO panDuanDAO;
	@Resource
	private Questions_TianKongDAO tianKongDAO;
	@Resource
	private Questions_DanXuanDAO danXuanDAO;
	@Resource
	private Questions_DuoXuanDAO duoXuanDAO;
	/**
	 * 试题 试卷 信息
	 */
	@Resource
	private ExamPaperDAO examPaperDAO;
	@Resource
	private PaperClassifyDAO paperClassifyDAO;
	@Resource
	private PaperGroupingDAO paperGroupingDAO;
	@Resource
	private PaperSourceDAO paperSourceDAO;
	@Resource
	private QuestionsGroupingDAO questionsGroupingDAO;	/**
	 * 考勤
	 */
	@Resource
	private AttendanceMainDao attendanceMainDao;
	@Resource
	private AttendanceListDao attendanceListDao;
	
	/**
	 * 实训
	 */
	@Resource
	private PracticalTrainingTemplateDao practicalTrainingTemplateDao;

	/**
	 * 封装
	 * @return
	 */
	public DifficultyGuidanceDAO getDifficultyGuidanceDAO() {
		return difficultyGuidanceDAO;
	}

	public void setDifficultyGuidanceDAO(DifficultyGuidanceDAO difficultyGuidanceDAO) {
		this.difficultyGuidanceDAO = difficultyGuidanceDAO;
	}

	public ExcellentTeacherDAO getExcellentTeacherDAO() {
		return excellentTeacherDAO;
	}

	public void setExcellentTeacherDAO(ExcellentTeacherDAO excellentTeacherDAO) {
		this.excellentTeacherDAO = excellentTeacherDAO;
	}

	public ExpandApplicationDAO getExpandApplicationDAO() {
		return expandApplicationDAO;
	}

	public void setExpandApplicationDAO(ExpandApplicationDAO expandApplicationDAO) {
		this.expandApplicationDAO = expandApplicationDAO;
	}

	public ExcellentCourseDAO getExcellentCourseDAO() {
		return excellentCourseDAO;
	}

	public void setExcellentCourseDAO(ExcellentCourseDAO excellentCourseDAO) {
		this.excellentCourseDAO = excellentCourseDAO;
	}

	public ExperimentCaseDAO getExperimentCaseDAO() {
		return experimentCaseDAO;
	}

	public void setExperimentCaseDAO(ExperimentCaseDAO experimentCaseDAO) {
		this.experimentCaseDAO = experimentCaseDAO;
	}

	public LessionBookDAO getLessionBookDAO() {
		return lessionBookDAO;
	}

	public void setLessionBookDAO(LessionBookDAO lessionBookDAO) {
		this.lessionBookDAO = lessionBookDAO;
	}

	public ReferenceDataDAO getReferenceDataDAO() {
		return referenceDataDAO;
	}

	public void setReferenceDataDAO(ReferenceDataDAO referenceDataDAO) {
		this.referenceDataDAO = referenceDataDAO;
	}

	public ExcellentVideoDAO getExcellentVideoDAO() {
		return excellentVideoDAO;
	}

	public void setExcellentVideoDAO(ExcellentVideoDAO excellentVideoDAO) {
		this.excellentVideoDAO = excellentVideoDAO;
	}

	public ImgCarouselDAO getImgCarouselDAO() {
		return imgCarouselDAO;
	}

	public void setImgCarouselDAO(ImgCarouselDAO imgCarouselDAO) {
		this.imgCarouselDAO = imgCarouselDAO;
	}

	public PostDAO getPostDAO() {
		return postDAO;
	}

	public void setPostDAO(PostDAO postDAO) {
		this.postDAO = postDAO;
	}

	public ResponseDAO getResponseDAO() {
		return responseDAO;
	}

	public void setResponseDAO(ResponseDAO responseDAO) {
		this.responseDAO = responseDAO;
	}

	public TypeDAO getTypeDAO() {
		return typeDAO;
	}

	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}

	public ClassRoomDAO getClassRoomDAO() {
		return classRoomDAO;
	}

	public void setClassRoomDAO(ClassRoomDAO classRoomDAO) {
		this.classRoomDAO = classRoomDAO;
	}

	public CourseDAO getCourseDAO() {
		return courseDAO;
	}

	public void setCourseDAO(CourseDAO courseDAO) {
		this.courseDAO = courseDAO;
	}

	public DepartmentDAO getDepartmentDAO() {
		return departmentDAO;
	}

	public void setDepartmentDAO(DepartmentDAO departmentDAO) {
		this.departmentDAO = departmentDAO;
	}

	public MajorDao getMajorDao() {
		return majorDao;
	}

	public void setMajorDao(MajorDao majorDao) {
		this.majorDao = majorDao;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public TeacherDao getTeacherDao() {
		return teacherDao;
	}

	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}

	public ComputerRoomDao getComputerRoomDao() {
		return computerRoomDao;
	}

	public void setComputerRoomDao(ComputerRoomDao computerRoomDao) {
		this.computerRoomDao = computerRoomDao;
	}

	public ClassifyDAO getClassifyDAO() {
		return classifyDAO;
	}

	public void setClassifyDAO(ClassifyDAO classifyDAO) {
		this.classifyDAO = classifyDAO;
	}

	public DifficultyDAO getDifficultyDAO() {
		return difficultyDAO;
	}

	public void setDifficultyDAO(DifficultyDAO difficultyDAO) {
		this.difficultyDAO = difficultyDAO;
	}

	public GroupingDAO getGroupingDAO() {
		return groupingDAO;
	}

	public void setGroupingDAO(GroupingDAO groupingDAO) {
		this.groupingDAO = groupingDAO;
	}

	public QuestionsDAO getQuestionsDAO() {
		return questionsDAO;
	}

	public void setQuestionsDAO(QuestionsDAO questionsDAO) {
		this.questionsDAO = questionsDAO;
	}

	public SourceDAO getSourceDAO() {
		return sourceDAO;
	}

	public void setSourceDAO(SourceDAO sourceDAO) {
		this.sourceDAO = sourceDAO;
	}

	public Questions_JianDaDAO getJianDaDAO() {
		return jianDaDAO;
	}

	public void setJianDaDAO(Questions_JianDaDAO jianDaDAO) {
		this.jianDaDAO = jianDaDAO;
	}

	public Questions_PanDuanDAO getPanDuanDAO() {
		return panDuanDAO;
	}

	public void setPanDuanDAO(Questions_PanDuanDAO panDuanDAO) {
		this.panDuanDAO = panDuanDAO;
	}

	public Questions_TianKongDAO getTianKongDAO() {
		return tianKongDAO;
	}

	public void setTianKongDAO(Questions_TianKongDAO tianKongDAO) {
		this.tianKongDAO = tianKongDAO;
	}

	public Questions_DanXuanDAO getDanXuanDAO() {
		return danXuanDAO;
	}

	public void setDanXuanDAO(Questions_DanXuanDAO danXuanDAO) {
		this.danXuanDAO = danXuanDAO;
	}

	public Questions_DuoXuanDAO getDuoXuanDAO() {
		return duoXuanDAO;
	}

	public void setDuoXuanDAO(Questions_DuoXuanDAO duoXuanDAO) {
		this.duoXuanDAO = duoXuanDAO;
	}

	public ExamPaperDAO getExamPaperDAO() {
		return examPaperDAO;
	}

	public void setExamPaperDAO(ExamPaperDAO examPaperDAO) {
		this.examPaperDAO = examPaperDAO;
	}

	public PaperClassifyDAO getPaperClassifyDAO() {
		return paperClassifyDAO;
	}

	public void setPaperClassifyDAO(PaperClassifyDAO paperClassifyDAO) {
		this.paperClassifyDAO = paperClassifyDAO;
	}

	public PaperGroupingDAO getPaperGroupingDAO() {
		return paperGroupingDAO;
	}

	public void setPaperGroupingDAO(PaperGroupingDAO paperGroupingDAO) {
		this.paperGroupingDAO = paperGroupingDAO;
	}

	public PaperSourceDAO getPaperSourceDAO() {
		return paperSourceDAO;
	}

	public void setPaperSourceDAO(PaperSourceDAO paperSourceDAO) {
		this.paperSourceDAO = paperSourceDAO;
	}

	public QuestionsGroupingDAO getQuestionsGroupingDAO() {
		return questionsGroupingDAO;
	}

	public void setQuestionsGroupingDAO(QuestionsGroupingDAO questionsGroupingDAO) {
		this.questionsGroupingDAO = questionsGroupingDAO;
	}

	public AttendanceMainDao getAttendanceMainDao() {
		return attendanceMainDao;
	}

	public void setAttendanceMainDao(AttendanceMainDao attendanceMainDao) {
		this.attendanceMainDao = attendanceMainDao;
	}

	public AttendanceListDao getAttendanceListDao() {
		return attendanceListDao;
	}

	public void setAttendanceListDao(AttendanceListDao attendanceListDao) {
		this.attendanceListDao = attendanceListDao;
	}

	public PracticalTrainingTemplateDao getPracticalTrainingTemplateDao() {
		return practicalTrainingTemplateDao;
	}

	public void setPracticalTrainingTemplateDao(
			PracticalTrainingTemplateDao practicalTrainingTemplateDao) {
		this.practicalTrainingTemplateDao = practicalTrainingTemplateDao;
	}
	
	

	
	
}
