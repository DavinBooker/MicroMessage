/**
 * ���ú�̨����ɾ������
 * @param basePath
 */
function deleteBatch(basePath){
	$("#mainForm").attr("action",basePath+"DeleteBatchServlet.action");
	$("#mainForm").submit();
}