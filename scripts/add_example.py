# This will be made a bit more general later.
# It is kind of hard-wired for a very specific task (to create the same build file for
# each intro CS example.

import build
import os
import os.path
import sys

def main():
   new_example = sys.argv[1]
   existing_examples = os.listdir('.')
   if not new_example in existing_examples:
      reldir = os.path.join('.',new_example)
      os.mkdir(reldir)
      buildsbt = os.path.join(reldir,'build.sbt')
      with open(buildsbt,"w") as f:
         f.write(build.TEMPLATE % { 'name' : new_example, 'scala' : '2.11.5', 'pct' : '%' })
      print("Wrote " + buildsbt)
   else:
      print("Did not write" + buildsbt)

if __name__ == '__main__':
   main()       
