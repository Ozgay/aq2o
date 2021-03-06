/****

    activequant - activestocks.eu

    This program is free software; you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation; either version 2 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License along
    with this program; if not, write to the Free Software Foundation, Inc.,
    51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.

	
	contact  : contact@activestocks.eu
    homepage : http://www.activestocks.eu

****/
package com.activequant.utils;

import java.lang.reflect.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

/**
 * @TODO desc<br>
 * <br>
 * <b>History:</b><br>
 *  - [11.06.2007] Created (Erik Nijkamp)<br>
 *  - [11.06.2007] Added converters, dumper (Ulrich Staudinger)<br>
 *  - [11.06.2012] More converters and decimalformatter (Ulrich Staudinger)<br>
 *
 *  @author Erik Nijkamp
 *  @author Ulrich Staudinger
 */
public class ArrayUtils {

	private static DecimalFormat dcf = new DecimalFormat("#.########");
	
	public static void setDecimalFormat(String formatString){
		dcf = new DecimalFormat(formatString);
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] asArray(final Collection<T> list, Class<T> clazz) {
		T[] emptyArray = (T[]) Array.newInstance(clazz, 0);
		return list == null ? emptyArray : list.toArray(emptyArray);
	}
	
	public static <T> List<T> asList(final T[] array) {
		return array == null ? new ArrayList<T>() : new ArrayList<T>(java.util.Arrays.asList(array));
	}
	
	public static <T> Vector<T> asVector(final T[] array) {
		return array == null ? new Vector<T>() : new Vector<T>(java.util.Arrays.asList(array));
	}
	
	public static <T> void reverse(T[] b) {
		for (int left = 0, right = b.length - 1; left < right; left++, right--) {
			// exchange the first and last
			T temp = b[left];
			b[left] = b[right];
			b[right] = temp;
		}
	}
	
	public static void reverse(double[] b) {
		for (int left = 0, right = b.length - 1; left < right; left++, right--) {
			// exchange the first and last
			double temp = b[left];
			b[left] = b[right];
			b[right] = temp;
		}
	}
	
	
    public static String toString(Double[] input){
        StringBuilder ret = new StringBuilder();
        for(Double o : input){
            ret.append("");
            if(o!=null)
            	ret.append(""+dcf.format(o));
            else 
            	ret.append("NULL");
            ret.append(" ");
        }
        return ret.toString();
    }
    
    public static String toString(double[] input){
        StringBuilder ret = new StringBuilder();
        for(double o : input){
            ret.append(dcf.format(o));
            ret.append(", ");
        }
        ret.delete(ret.length()-2, ret.length());
        return ret.toString();
    }
    
    public static String toString(String[] input){
        StringBuilder ret = new StringBuilder();
        for(String o : input){
            ret.append(o);
            ret.append(", ");
        }
        if(ret.length()>2)ret.delete(ret.length()-2, ret.length());
        return ret.toString();
    }
    
    public static String toString(Double[][] input){
        StringBuilder ret = new StringBuilder();
        for(Double[] o : input){
            ret.append(toString(o));
            ret.append("\n");
        }
        return ret.toString();
    }
	public static double[] convert(Collection<Double> list) {
		return convert(list.toArray(new Double[] {}));
	}
	
	public static double[] convert(Double[] in){
		double[] ret = new double[in.length];
		for(int i=0;i<in.length;i++){
			ret[i] = in[i];
		}
		return ret; 
	}
	
	public static Double[] convert(double[] in){
		Double[] ret = new Double[in.length];
		for(int i=0;i<in.length;i++){
			ret[i] = in[i];
		}
		return ret; 
	}
	
	public static double[][] convert(Double[][] in){
		double[][] ret = new double[in.length][in[0].length];
		for(int i=0;i<in.length;i++){
			for(int j = 0; j<in[0].length;j++){
				ret[i][j] = in[i][j];
			}
		}
		return ret; 
	}

	public static List<Double> toDoubleListSkipNull(Double[] in){
		List<Double> ret = new ArrayList<Double>();
		for(Double d : in)
			if(d!=null)
				ret.add(d);
		return ret;
	}
	
	
	public static List<Double> toDoubleList(Double[] in){
		List<Double> ret = new ArrayList<Double>();
		for(Double d : in)
			ret.add(d);
		return ret;
	}
	
	public static List<Double> toDoubleList(double[] in){
		List<Double> ret = new ArrayList<Double>();
		for(double d : in)
			ret.add(d);
		return ret;
	}
	
	public static double[] toPrimArray(List<Double> in){
		double[] ret = new double[in.size()];
		for(int j = 0; j<in.size();j++){
			ret[j] = in.get(j);
		}
		return ret; 
	}
	
	public static double[] unbox(Double[] in){
		double[] ret = new double[in.length];
		for(int j = 0; j<in.length;j++){
			if(in[j]!=null)
				ret[j] = in[j];
		}
		return ret; 
	}
	
	public List<Object[]> c(Object[][] in){
		List<Object[]> rows = new ArrayList<Object[]>();
		for(int i=0;i<in.length;i++){
			rows.add(in[i]);
		}
		return rows; 
	}
	

	public Object[][] c(List<Object[]> in){
		Object[][] out = new Object[in.size()][];
		for(int i=0;i<in.size();i++){
			out[i] = in.get(i);
		}
		return out; 
	}
	
}
