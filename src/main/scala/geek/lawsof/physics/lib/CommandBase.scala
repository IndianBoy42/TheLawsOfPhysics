package geek.lawsof.physics.lib

import geek.lawsof.physics.Reference
import net.minecraft.command.{ICommandSender, ICommand}

/**
 * Created by anshuman on 22-07-2014.
 */
class CommandBase(val getCommandName: String, val process: (ICommandSender, Array[String]) => Unit) extends net.minecraft.command.CommandBase{
  override def getCommandUsage(p : ICommandSender): String = s"${Reference.MOD_ID}.${getCommandName}.usage"

  override def processCommand(p : ICommandSender, args : Array[String]): Unit = process(p, args)
}