package cn.qlk.test.until;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import cn.qlk.test.bean.CaseManger;
/**
 * excel工具类,支持批量导出
 * @author lizewu
 *
 */
public class ExportExcelUntil {
    
    /**
     * 将用户的信息导入到excel文件中去
     * @param userList 用户列表
     * @param out 输出表
     * @param reg 
     */
    public static void exportUserExcel(List<CaseManger> caseMangers,HttpServletResponse out,String title)
    {
        try{
            //1.创建工作簿
        	XSSFWorkbook workbook = new XSSFWorkbook();
            //1.1创建合并单元格对象
            CellRangeAddress callRangeAddress = new CellRangeAddress(0,0,0,9);//起始行,结束行,起始列,结束列
            //1.2头标题样式
            XSSFCellStyle headStyle = createCellStyle(workbook,(short)16);
            //1.3列标题样式
            XSSFCellStyle colStyle = createCellStyle(workbook,(short)13);
            //2.创建工作表
            XSSFSheet sheet = workbook.createSheet("用例列表");
            //2.1加载合并单元格对象
            sheet.addMergedRegion(callRangeAddress);
            //设置默认列宽
            sheet.setDefaultColumnWidth(25);
            //3.创建行
            //3.1创建头标题行;并且设置头标题
            XSSFRow row = sheet.createRow(0);
            XSSFCell cell = row.createCell(0);
        
            //加载单元格样式
            cell.setCellStyle(headStyle);
            cell.setCellValue("用例列表");
            
            //3.2创建列标题;并且设置列标题
            XSSFRow row2 = sheet.createRow(1);
            String[] titles = {"接口名称","接口地址","归属平台","请求方式","请求参数","参数格式","预期结果","用例描述","是否依赖","依赖关系","是否含请求头","请求头"};
            for(int i=0;i<titles.length;i++)
            {
                XSSFCell cell2 = row2.createCell(i);
                //加载单元格样式
                cell2.setCellStyle(colStyle);
                cell2.setCellValue(titles[i]);
            }
            
            
            //4.操作单元格;将用户列表写入excel
            if(caseMangers != null)
            {
                for(int j=0;j<caseMangers.size();j++)
                {
                    //创建数据行,前面有两行,头标题行和列标题行
                    XSSFRow row3 = sheet.createRow(j+2);
                    XSSFCell cell1 = row3.createCell(0);
                    cell1.setCellValue(caseMangers.get(j).getInterfaceName());
                    XSSFCell cell2 = row3.createCell(1);
                    cell2.setCellValue(caseMangers.get(j).getInterfaceAdress());
                    XSSFCell cell3 = row3.createCell(2);
                    cell3.setCellValue(caseMangers.get(j).getRegion());
                    XSSFCell cell4 = row3.createCell(3);
                    cell4.setCellValue(caseMangers.get(j).getInterfaceType());
                    XSSFCell cell5 = row3.createCell(4);
                    cell5.setCellValue(caseMangers.get(j).getInterfaceParameter());
                    
                    XSSFCell cell6 = row3.createCell(5);
                    cell6.setCellValue(caseMangers.get(j).getParameterType());
                    XSSFCell cell7 = row3.createCell(6);
                    cell7.setCellValue(caseMangers.get(j).getExpectResult());
                    XSSFCell cell8 = row3.createCell(7);
                    cell8.setCellValue(caseMangers.get(j).getInterfaceDese());
                    
                    XSSFCell cell9 = row3.createCell(8);
                    cell9.setCellValue(caseMangers.get(j).getDependStatus());
                    
                    XSSFCell cell10 = row3.createCell(9);
                    cell10.setCellValue(caseMangers.get(j).getDepend());
                    
                    XSSFCell cell11 = row3.createCell(10);
                    cell11.setCellValue(caseMangers.get(j).getHeaderStatus());
                    
                    XSSFCell cell12 = row3.createCell(11);
                    cell12.setCellValue(caseMangers.get(j).getHeader());
                    
                }
            }
            //5.输出
            out.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            out.setHeader("Content-disposition", "attachment;filename="+new String(title.getBytes("utf-8"),"iso-8859-1")+".xlsx");
            
            workbook.write(out.getOutputStream());
            workbook.close();
            //out.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * @param workbook
     * @param fontsize
     * @return 单元格样式
     */
    private static XSSFCellStyle createCellStyle(XSSFWorkbook workbook, short fontsize) {
        // TODO Auto-generated method stub
        XSSFCellStyle style = workbook.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//水平居中
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//垂直居中
        //创建字体
        XSSFFont font = workbook.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints(fontsize);
        //加载字体
        style.setFont(font);
        return style;
    }
}