/*
   Copyright 2012 Harri Smatt

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package fi.harism.lucidchat;

import android.os.Parcel;
import android.os.Parcelable;

public class ChatMessage implements Parcelable {

	public static final int CMD_EXCEPTION = 1;
	public static final int CMD_JOIN = 2;
	public static final int CMD_PART = 3;
	public static final int CMD_PING = 4;
	public static final int CMD_PRIVMSG = 5;
	public static final int CMD_PRIVMSG_ACTION = 6;
	public static final int CMD_SERVERMSG = 7;
	public static final int CMD_SERVERMSG_ERROR = 8;
	public static final int CMD_UNKNOWN = -1;

	public static final Parcelable.Creator<ChatMessage> CREATOR = new Parcelable.Creator<ChatMessage>() {
		@Override
		public ChatMessage createFromParcel(Parcel in) {
			return new ChatMessage(in);
		}

		@Override
		public ChatMessage[] newArray(int size) {
			return new ChatMessage[size];
		}
	};

	public int mCommand;
	public String mConversation, mFrom, mMessage;
	public long mTime;

	public ChatMessage() {
		mTime = System.currentTimeMillis();
	}

	private ChatMessage(Parcel in) {
		mCommand = in.readInt();
		mConversation = in.readString();
		mFrom = in.readString();
		mMessage = in.readString();
		mTime = in.readLong();
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel out, int flags) {
		out.writeInt(mCommand);
		out.writeString(mConversation);
		out.writeString(mFrom);
		out.writeString(mMessage);
		out.writeLong(mTime);
	}

}
