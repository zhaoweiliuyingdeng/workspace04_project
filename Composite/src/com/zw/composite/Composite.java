package com.zw.composite;

import java.util.ArrayList;

import com.zw.component.Component;

public class Composite implements Component {
	private ArrayList<Component> childern = new ArrayList<Component>() ;

	@Override
	public void add(Component c) {
		childern.add(c) ;

	}

	@Override
	public void remove(Component c) {
		childern.remove(c) ;

	}

	@Override
	public Component gitChild(int i) {
		
		return childern.get(i);
	}

	@Override
	public void operation() {
        for(Object obj:childern)
        {
            ((Component)obj).operation();
        }

	}

}
