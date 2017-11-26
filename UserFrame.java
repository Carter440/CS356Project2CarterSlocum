import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class UserFrame{

	public UserFrame(User u){
		JFrame userFrame = new JFrame();
		JPanel follow = new JPanel();
		JPanel following = new JPanel();
		JPanel tweet = new JPanel();
		JPanel feed = new JPanel();
		JLabel title = new JLabel(u.getID() + " Created at Time: " + Long.toString(u.getCreationTime()));
		JTextField uid = new JTextField("User ID");
		JTextField tweetText = new JTextField("Tweet Text");
		JTextArea followingList = new JTextArea("Following:\n");
		JTextArea feedList = new JTextArea("News Feed Last Updated at " + Long.toString(u.getUpdateTime()) + ":\n");
		JButton followButton = new JButton("Follow User");
		followButton.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	u.follow(uid.getText());
		    	updateFollowing(followingList, u);
		    	updateFeed(feedList, u);
		    }  
		}); 
		JButton tweetButton = new JButton("Tweet");
		tweetButton.addActionListener(new ActionListener(){  
		    public void actionPerformed(ActionEvent e){  
		    	u.Tweet(tweetText.getText());
		    	updateFeed(feedList, u);
		    }  
		}); 
		updateFeed(feedList,u);
		updateFollowing(followingList,u);
		follow.add(uid); follow.add(followButton);
		following.add(followingList);
		feed.add(feedList);
		tweet.add(tweetText); tweet.add(tweetButton);
		userFrame.add(title);userFrame.add(follow);userFrame.add(following);userFrame.add(tweet);userFrame.add(feed);
		userFrame.setSize(400,500);
		follow.setLayout(new GridLayout(1,2));
		following.setLayout(new GridLayout(1,1));
		tweet.setLayout(new GridLayout(1,2));
		feed.setLayout(new GridLayout(1,1));
		userFrame.setLayout(new GridLayout(5,1));
		userFrame.setVisible(true);
	}
	
	private void updateFeed(JTextArea f, User u){
		f.setText("News Feed Last Updated at " + Long.toString(u.getUpdateTime()) + ":\n");
		for (String[] s: u.getMessages()){
			String st = s[0] + ": " + s[1] + "\n";
			f.append(st);
		}
	}
	private void updateFollowing(JTextArea f, User u){
		f.setText("Following:\n");
		for (String s: u.getFollowing()){
			f.append(s+"\n");
		}
	}

}
