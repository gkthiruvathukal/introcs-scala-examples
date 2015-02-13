# This will be made a bit more general later.
# It is kind of hard-wired for a very specific task (to create the same build file for
# each intro CS example.

import build
import os
import os.path

def main():
   exclusions = ['.', '..', '.git', '.gitignore', 'scripts']
   for dir in os.listdir('..'):
      if dir.startswith('.'):
         continue
      if dir in exclusions:
         continue
      reldir = os.path.join('..',dir)
      if not os.path.isdir(reldir):
         continue

      buildsbt = os.path.join(reldir,'build.sbt')
      with open(buildsbt,"w") as f:
         f.write(build.TEMPLATE % { 'name' : dir, 'scala' : '2.11.5', 'pct' : '%' })
      print("Wrote " + buildsbt)

if __name__ == '__main__':
   main()       
