import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.ScriptOpcodes;

@ObfuscatedName("el")
@Implements("Entity")
public abstract class Entity extends DualNode {
	@ObfuscatedName("cu")
	@ObfuscatedGetter(
		intValue = -1335402999
	)
	@Export("height")
	public int height;

	protected Entity() {
		this.height = 1000;
	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(I)Lef;",
		garbageValue = "1832696685"
	)
	@Export("getModel")
	protected Model getModel() {
		return null;
	}

	@ObfuscatedName("cz")
	@Export("draw")
	void draw(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, long var9) {
		Model var11 = this.getModel();
		if (var11 != null) {
			this.height = var11.height;
			var11.draw(var1, var2, var3, var4, var5, var6, var7, var8, var9);
		}

	}

	@ObfuscatedName("a")
	@ObfuscatedSignature(
		descriptor = "(B)V",
		garbageValue = "67"
	)
	public static void method3387() {
		KitDefinition.KitDefinition_cached.clear();
	}

	@ObfuscatedName("ad")
	@ObfuscatedSignature(
		descriptor = "(ILcs;ZI)I",
		garbageValue = "-1309600698"
	)
	static int method3376(int var0, Script var1, boolean var2) {
		if (var0 == ScriptOpcodes.CHAT_GETFILTER_PUBLIC) {
			Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = Client.publicChatMode;
			return 1;
		} else if (var0 == ScriptOpcodes.CHAT_SETFILTER) {
			UrlRequester.Interpreter_intStackSize -= 3;
			Client.publicChatMode = Interpreter.Interpreter_intStack[UrlRequester.Interpreter_intStackSize];
			World.privateChatMode = ItemContainer.method1232(Interpreter.Interpreter_intStack[UrlRequester.Interpreter_intStackSize + 1]);
			if (World.privateChatMode == null) {
				World.privateChatMode = PrivateChatMode.field3818;
			}

			Client.tradeChatMode = Interpreter.Interpreter_intStack[UrlRequester.Interpreter_intStackSize + 2];
			PacketBufferNode var18 = UserComparator4.getPacketBufferNode(ClientPacket.field2324, Client.packetWriter.isaacCipher);
			var18.packetBuffer.writeByte(Client.publicChatMode);
			var18.packetBuffer.writeByte(World.privateChatMode.field3817);
			var18.packetBuffer.writeByte(Client.tradeChatMode);
			Client.packetWriter.addNode(var18);
			return 1;
		} else {
			String var3;
			int var4;
			if (var0 == ScriptOpcodes.CHAT_SENDABUSEREPORT) {
				var3 = Interpreter.Interpreter_stringStack[--WorldMapEvent.Interpreter_stringStackSize];
				UrlRequester.Interpreter_intStackSize -= 2;
				var4 = Interpreter.Interpreter_intStack[UrlRequester.Interpreter_intStackSize];
				int var5 = Interpreter.Interpreter_intStack[UrlRequester.Interpreter_intStackSize + 1];
				PacketBufferNode var6 = UserComparator4.getPacketBufferNode(ClientPacket.field2341, Client.packetWriter.isaacCipher);
				var6.packetBuffer.writeByte(DynamicObject.stringCp1252NullTerminatedByteSize(var3) + 2);
				var6.packetBuffer.writeStringCp1252NullTerminated(var3);
				var6.packetBuffer.writeByte(var4 - 1);
				var6.packetBuffer.writeByte(var5);
				Client.packetWriter.addNode(var6);
				return 1;
			} else {
				int var10;
				if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYTYPEANDLINE) {
					UrlRequester.Interpreter_intStackSize -= 2;
					var10 = Interpreter.Interpreter_intStack[UrlRequester.Interpreter_intStackSize];
					var4 = Interpreter.Interpreter_intStack[UrlRequester.Interpreter_intStackSize + 1];
					Message var15 = class3.Messages_getByChannelAndID(var10, var4);
					if (var15 != null) {
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = var15.count;
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = var15.cycle;
						Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = var15.sender != null ? var15.sender : "";
						Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = var15.prefix != null ? var15.prefix : "";
						Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = var15.text != null ? var15.text : "";
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = var15.isFromFriend() ? 1 : (var15.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETHISTORY_BYUID) {
					var10 = Interpreter.Interpreter_intStack[--UrlRequester.Interpreter_intStackSize];
					Message var16 = Language.Messages_getMessage(var10);
					if (var16 != null) {
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = var16.type;
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = var16.cycle;
						Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = var16.sender != null ? var16.sender : "";
						Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = var16.prefix != null ? var16.prefix : "";
						Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = var16.text != null ? var16.text : "";
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = var16.isFromFriend() ? 1 : (var16.isFromIgnored() ? 2 : 0);
					} else {
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = -1;
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = 0;
						Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = "";
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = 0;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_GETFILTER_PRIVATE) {
					if (World.privateChatMode == null) {
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = -1;
					} else {
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = World.privateChatMode.field3817;
					}

					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPUBLIC) {
					var3 = Interpreter.Interpreter_stringStack[--WorldMapEvent.Interpreter_stringStackSize];
					var4 = Interpreter.Interpreter_intStack[--UrlRequester.Interpreter_intStackSize];
					String var14 = var3.toLowerCase();
					byte var17 = 0;
					if (var14.startsWith("yellow:")) {
						var17 = 0;
						var3 = var3.substring("yellow:".length());
					} else if (var14.startsWith("red:")) {
						var17 = 1;
						var3 = var3.substring("red:".length());
					} else if (var14.startsWith("green:")) {
						var17 = 2;
						var3 = var3.substring("green:".length());
					} else if (var14.startsWith("cyan:")) {
						var17 = 3;
						var3 = var3.substring("cyan:".length());
					} else if (var14.startsWith("purple:")) {
						var17 = 4;
						var3 = var3.substring("purple:".length());
					} else if (var14.startsWith("white:")) {
						var17 = 5;
						var3 = var3.substring("white:".length());
					} else if (var14.startsWith("flash1:")) {
						var17 = 6;
						var3 = var3.substring("flash1:".length());
					} else if (var14.startsWith("flash2:")) {
						var17 = 7;
						var3 = var3.substring("flash2:".length());
					} else if (var14.startsWith("flash3:")) {
						var17 = 8;
						var3 = var3.substring("flash3:".length());
					} else if (var14.startsWith("glow1:")) {
						var17 = 9;
						var3 = var3.substring("glow1:".length());
					} else if (var14.startsWith("glow2:")) {
						var17 = 10;
						var3 = var3.substring("glow2:".length());
					} else if (var14.startsWith("glow3:")) {
						var17 = 11;
						var3 = var3.substring("glow3:".length());
					} else if (UserComparator9.clientLanguage != Language.Language_EN) {
						if (var14.startsWith("yellow:")) {
							var17 = 0;
							var3 = var3.substring("yellow:".length());
						} else if (var14.startsWith("red:")) {
							var17 = 1;
							var3 = var3.substring("red:".length());
						} else if (var14.startsWith("green:")) {
							var17 = 2;
							var3 = var3.substring("green:".length());
						} else if (var14.startsWith("cyan:")) {
							var17 = 3;
							var3 = var3.substring("cyan:".length());
						} else if (var14.startsWith("purple:")) {
							var17 = 4;
							var3 = var3.substring("purple:".length());
						} else if (var14.startsWith("white:")) {
							var17 = 5;
							var3 = var3.substring("white:".length());
						} else if (var14.startsWith("flash1:")) {
							var17 = 6;
							var3 = var3.substring("flash1:".length());
						} else if (var14.startsWith("flash2:")) {
							var17 = 7;
							var3 = var3.substring("flash2:".length());
						} else if (var14.startsWith("flash3:")) {
							var17 = 8;
							var3 = var3.substring("flash3:".length());
						} else if (var14.startsWith("glow1:")) {
							var17 = 9;
							var3 = var3.substring("glow1:".length());
						} else if (var14.startsWith("glow2:")) {
							var17 = 10;
							var3 = var3.substring("glow2:".length());
						} else if (var14.startsWith("glow3:")) {
							var17 = 11;
							var3 = var3.substring("glow3:".length());
						}
					}

					var14 = var3.toLowerCase();
					byte var7 = 0;
					if (var14.startsWith("wave:")) {
						var7 = 1;
						var3 = var3.substring("wave:".length());
					} else if (var14.startsWith("wave2:")) {
						var7 = 2;
						var3 = var3.substring("wave2:".length());
					} else if (var14.startsWith("shake:")) {
						var7 = 3;
						var3 = var3.substring("shake:".length());
					} else if (var14.startsWith("scroll:")) {
						var7 = 4;
						var3 = var3.substring("scroll:".length());
					} else if (var14.startsWith("slide:")) {
						var7 = 5;
						var3 = var3.substring("slide:".length());
					} else if (Language.Language_EN != UserComparator9.clientLanguage) {
						if (var14.startsWith("wave:")) {
							var7 = 1;
							var3 = var3.substring("wave:".length());
						} else if (var14.startsWith("wave2:")) {
							var7 = 2;
							var3 = var3.substring("wave2:".length());
						} else if (var14.startsWith("shake:")) {
							var7 = 3;
							var3 = var3.substring("shake:".length());
						} else if (var14.startsWith("scroll:")) {
							var7 = 4;
							var3 = var3.substring("scroll:".length());
						} else if (var14.startsWith("slide:")) {
							var7 = 5;
							var3 = var3.substring("slide:".length());
						}
					}

					PacketBufferNode var8 = UserComparator4.getPacketBufferNode(ClientPacket.field2273, Client.packetWriter.isaacCipher);
					var8.packetBuffer.writeByte(0);
					int var9 = var8.packetBuffer.offset;
					var8.packetBuffer.writeByte(var4);
					var8.packetBuffer.writeByte(var17);
					var8.packetBuffer.writeByte(var7);
					DevicePcmPlayerProvider.method917(var8.packetBuffer, var3);
					var8.packetBuffer.writeLengthByte(var8.packetBuffer.offset - var9);
					Client.packetWriter.addNode(var8);
					return 1;
				} else if (var0 == ScriptOpcodes.CHAT_SENDPRIVATE) {
					WorldMapEvent.Interpreter_stringStackSize -= 2;
					var3 = Interpreter.Interpreter_stringStack[WorldMapEvent.Interpreter_stringStackSize];
					String var12 = Interpreter.Interpreter_stringStack[WorldMapEvent.Interpreter_stringStackSize + 1];
					PacketBufferNode var11 = UserComparator4.getPacketBufferNode(ClientPacket.field2247, Client.packetWriter.isaacCipher);
					var11.packetBuffer.writeShort(0);
					int var13 = var11.packetBuffer.offset;
					var11.packetBuffer.writeStringCp1252NullTerminated(var3);
					DevicePcmPlayerProvider.method917(var11.packetBuffer, var12);
					var11.packetBuffer.writeLengthShort(var11.packetBuffer.offset - var13);
					Client.packetWriter.addNode(var11);
					return 1;
				} else if (var0 != ScriptOpcodes.CHAT_PLAYERNAME) {
					if (var0 == ScriptOpcodes.CHAT_GETFILTER_TRADE) {
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = Client.tradeChatMode;
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETHISTORYLENGTH) {
						var10 = Interpreter.Interpreter_intStack[--UrlRequester.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = GrandExchangeEvent.Messages_getHistorySize(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETNEXTUID) {
						var10 = Interpreter.Interpreter_intStack[--UrlRequester.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = class171.Messages_getNextChatID(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETPREVUID) {
						var10 = Interpreter.Interpreter_intStack[--UrlRequester.Interpreter_intStackSize];
						Interpreter.Interpreter_intStack[++UrlRequester.Interpreter_intStackSize - 1] = WorldMapLabel.Messages_getLastChatID(var10);
						return 1;
					} else if (var0 == ScriptOpcodes.DOCHEAT) {
						var3 = Interpreter.Interpreter_stringStack[--WorldMapEvent.Interpreter_stringStackSize];
						WallDecoration.doCheat(var3);
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_SETMESSAGEFILTER) {
						Client.field755 = Interpreter.Interpreter_stringStack[--WorldMapEvent.Interpreter_stringStackSize].toLowerCase().trim();
						return 1;
					} else if (var0 == ScriptOpcodes.CHAT_GETMESSAGEFILTER) {
						Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = Client.field755;
						return 1;
					} else if (var0 == ScriptOpcodes.DEBUGMES) {
						var3 = Interpreter.Interpreter_stringStack[--WorldMapEvent.Interpreter_stringStackSize];
						System.out.println(var3);
						return 1;
					} else {
						return 2;
					}
				} else {
					if (class60.localPlayer != null && class60.localPlayer.username != null) {
						var3 = class60.localPlayer.username.getName();
					} else {
						var3 = "";
					}

					Interpreter.Interpreter_stringStack[++WorldMapEvent.Interpreter_stringStackSize - 1] = var3;
					return 1;
				}
			}
		}
	}

	@ObfuscatedName("kl")
	@ObfuscatedSignature(
		descriptor = "(Lhd;I)Z",
		garbageValue = "-36347772"
	)
	@Export("isComponentHidden")
	static boolean isComponentHidden(Widget var0) {
		return var0.isHidden;
	}
}
