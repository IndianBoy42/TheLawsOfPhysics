package geek.lawsof.physics.init

import geek.lawsof.physics.LawsOfPhysicsMod
import net.minecraft.command.ICommand

/**
 * Created by anshuman on 22-07-2014.
 */
object ModCommands {
  def registerCommand(command: ICommand) = LawsOfPhysicsMod.serverStartEvt.registerServerCommand(command)

  def serverLoad() = {}
}
