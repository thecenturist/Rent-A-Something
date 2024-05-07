package com.rentasomething.app;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutPanel extends JPanel
{
	public AboutPanel() {
		this.setLayout(new BorderLayout());
		
		JPanel northPanel = new JPanel();
		JLabel createTitle = new JLabel("About This Application");
		northPanel.add(createTitle);
		this.add(northPanel, BorderLayout.NORTH);

		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(3, 2, 5, 18));
		JLabel aboutText = new JLabel();
		centerPanel.add(new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Cum sociis natoque penatibus et magnis dis parturient montes. Blandit volutpat maecenas volutpat blandit aliquam etiam erat velit scelerisque. Sed risus ultricies tristique nulla aliquet enim tortor at auctor. Elit sed vulputate mi sit amet mauris commodo quis imperdiet. Facilisis mauris sit amet massa vitae. Sed felis eget velit aliquet sagittis id consectetur. Adipiscing diam donec adipiscing tristique risus nec feugiat. Interdum varius sit amet mattis vulputate enim nulla aliquet. Vestibulum lectus mauris ultrices eros in cursus turpis massa tincidunt. Volutpat sed cras ornare arcu dui vivamus. Senectus et netus et malesuada fames. Consectetur lorem donec massa sapien faucibus et molestie ac. At augue eget arcu dictum.\r\n"
				+ "\r\n"
				+ "Sapien eget mi proin sed libero enim. In nibh mauris cursus mattis molestie a iaculis. Aliquet risus feugiat in ante metus dictum at tempor. Velit dignissim sodales ut eu sem integer. Tellus in metus vulputate eu scelerisque felis imperdiet proin. Ut etiam sit amet nisl purus in mollis. Interdum velit euismod in pellentesque massa placerat. Purus gravida quis blandit turpis cursus in hac. Varius quam quisque id diam. Vel quam elementum pulvinar etiam non quam lacus suspendisse faucibus. Faucibus scelerisque eleifend donec pretium vulputate. Massa tincidunt nunc pulvinar sapien et. Ornare aenean euismod elementum nisi. Egestas maecenas pharetra convallis posuere. Arcu non odio euismod lacinia at quis risus sed vulputate. Et molestie ac feugiat sed lectus vestibulum mattis ullamcorper velit. Nec dui nunc mattis enim ut.\r\n"
				+ "\r\n"
				+ "Nunc vel risus commodo viverra maecenas accumsan lacus. Est ullamcorper eget nulla facilisi etiam dignissim. Adipiscing at in tellus integer feugiat scelerisque varius morbi. Mi bibendum neque egestas congue quisque egestas diam. Nunc sed augue lacus viverra vitae congue eu consequat ac. Ac turpis egestas sed tempus urna et pharetra pharetra massa. Velit sed ullamcorper morbi tincidunt ornare massa eget egestas purus. Lacus vel facilisis volutpat est velit egestas. Id aliquet lectus proin nibh nisl condimentum id. Malesuada fames ac turpis egestas integer eget aliquet nibh praesent. Convallis aenean et tortor at risus. Tristique senectus et netus et malesuada fames ac turpis. Amet est placerat in egestas. Ipsum suspendisse ultrices gravida dictum fusce ut. Montes nascetur ridiculus mus mauris. Egestas sed sed risus pretium quam vulputate dignissim. Facilisis gravida neque convallis a cras semper auctor. Tempor nec feugiat nisl pretium fusce id."));
		
		
		this.add(centerPanel, BorderLayout.CENTER);
	}

}
