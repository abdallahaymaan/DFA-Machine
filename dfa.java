import java.util.*;


public class dfa {
	List<state> dfa_list;
	public dfa (String s ) {
		
		// 0,0,1;1,2,1;2,0,3;3,3,3#1,3
		dfa_list=new ArrayList<state>();
		String[] first_split= s.split("#");
		
		String [] states = first_split[0].split(";");
		for(String state1 : states) {
			String[]state_array = state1.split(",");
			state new_state = new state(Integer.parseInt(state_array[0]),Integer.parseInt(state_array[1]), Integer.parseInt(state_array[2]), check(first_split[1].split(","),state_array[0]));
			dfa_list.add(new_state);
		}
	}
	
	public Boolean run(String s) {
		state curr_state= dfa_list.get(0);
		for (int i = 0; i < s.length(); i++){
		    int c = Character.getNumericValue(s.charAt(i));
		    int new_state_index ;
		    if(c==0) {
		    	new_state_index = curr_state.next0;
		    }
		    else {
		    	new_state_index = curr_state.next1;

		    }
		    curr_state = dfa_list.get(new_state_index);
		    
		
		}
		
		return curr_state.goal;
		
	}
	
	private static boolean check(String [] arr , String valueToCheck) {
		for (String element : arr) {
			
            if (Integer.parseInt(element)== Integer.parseInt(valueToCheck)) {
                return true;
            }
        }
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		dfa dfa1 = new dfa("0,0,1;1,2,1;2,0,3;3,3,3#1,3");
		System.out.println("DFA1:");
		System.out.println(dfa1.run("11"));  
		System.out.println(dfa1.run("01010100"));  
		System.out.println(dfa1.run("100010010"));  
		System.out.println(dfa1.run("101"));  
		System.out.println(dfa1.run("0010"));  

		
		dfa dfa2 = new dfa("0,3,1;1,2,1;2,2,1;3,3,3#2");
		System.out.println();
		System.out.println("DFA2:");
		System.out.println(dfa2.run("010"));  
		System.out.println(dfa2.run("10101010"));  
		System.out.println(dfa2.run("10010"));  
		System.out.println(dfa2.run("100010011"));  
		System.out.println(dfa2.run("010010"));  

	}

}

